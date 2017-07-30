package Web;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/") + 1,
				uri.lastIndexOf("."));

		if (action.equals("register")) {
			//�ȿ���֤���Ƿ���ȷ
			String number1 = request.getParameter("number");
			String number2 = (String) request.getSession().getAttribute("number");
			if(!number1.equalsIgnoreCase(number2)){
				request.setAttribute("check_error", "��֤�����");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
			}
			
			String username = request.getParameter("username");

			// ��ѯ���ݿ⣬��username�Ƿ��Ѿ����ڣ�������ڣ�����ʾ�û���һ���û�����
			//���򣬽��û�ע�����Ϣ���뵽���ݿ⣬Ȼ����ת����¼ҳ��
			
			UserDAO dao = new UserDAO();
			try {
				User user = dao.findByUserName(username);
				if(user == null){
					//��֤�����ʽ
					String email = request.getParameter("email");
					String reg = "^\\w+@(qq|sina|gmail).(com|cn)$";
					//System.out.println(reg);
					Pattern p = Pattern.compile(reg);
					Matcher matcher = p.matcher(email);
					boolean bFlag = matcher.matches();
					if(!bFlag){
						request.setAttribute("email_error", "�����ʽ����ȷ");
						request.getRequestDispatcher("register.jsp").forward(request, response);
						return;
					}
					
					
					//�û���������
					user = new User();
					user.setUsername(username);
					user.setName(request.getParameter("name"));
					user.setPwd(request.getParameter("pwd"));
					user.setGender(request.getParameter("gender"));
					user.setEmail(email);
					dao.register(user);
					response.sendRedirect("login.jsp");
				}
				else{
					//�û����Ѵ���
					request.setAttribute("register_error", "�û����Ѵ���");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("login")){
			//�Ȳ鿴��֤���Ƿ���ȷ
			String number1 = request.getParameter("number");//������д����֤��
			
			HttpSession session = request.getSession();
			String number2 = (String) session.getAttribute("number");
			if(!number1.equalsIgnoreCase(number2)){
				//�����֤���������ʾ�û���֤�����
				request.setAttribute("check_error", "��֤�����");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");
			UserDAO dao = new UserDAO();
			
			try{
				User user = dao.findByUserName(username);
				if(user != null && user.getPwd().equals(pwd)){
					//��¼�ɹ�����ת��һ�������¼֮����ܷ��ʵ�ҳ��
					
					//���session��֤�Ĵ��룬
					//�Ȱ�һЩ���ݵ�session������,����session��֤
					
					session.setAttribute("user", user);
					
					response.sendRedirect("main.jsp");
				}else{
					//��¼ʧ��,��ʾ
					request.setAttribute("login_error", "�û��������������");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}catch(Exception e){
				
			}
		}
	}

}
