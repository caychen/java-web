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
			//先看验证码是否正确
			String number1 = request.getParameter("number");
			String number2 = (String) request.getSession().getAttribute("number");
			if(!number1.equalsIgnoreCase(number2)){
				request.setAttribute("check_error", "验证码错误");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
			}
			
			String username = request.getParameter("username");

			// 查询数据库，看username是否已经存在，如果存在，则提示用户换一个用户名，
			//否则，将用户注册的信息插入到数据库，然后跳转到登录页面
			
			UserDAO dao = new UserDAO();
			try {
				User user = dao.findByUserName(username);
				if(user == null){
					//验证邮箱格式
					String email = request.getParameter("email");
					String reg = "^\\w+@(qq|sina|gmail).(com|cn)$";
					//System.out.println(reg);
					Pattern p = Pattern.compile(reg);
					Matcher matcher = p.matcher(email);
					boolean bFlag = matcher.matches();
					if(!bFlag){
						request.setAttribute("email_error", "邮箱格式不正确");
						request.getRequestDispatcher("register.jsp").forward(request, response);
						return;
					}
					
					
					//用户名不存在
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
					//用户名已存在
					request.setAttribute("register_error", "用户名已存在");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("login")){
			//先查看验证码是否正确
			String number1 = request.getParameter("number");//表单上填写的验证码
			
			HttpSession session = request.getSession();
			String number2 = (String) session.getAttribute("number");
			if(!number1.equalsIgnoreCase(number2)){
				//如果验证码错误，则提示用户验证码错误
				request.setAttribute("check_error", "验证码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");
			UserDAO dao = new UserDAO();
			
			try{
				User user = dao.findByUserName(username);
				if(user != null && user.getPwd().equals(pwd)){
					//登录成功，跳转到一个必须登录之后才能访问的页面
					
					//添加session验证的代码，
					//先绑定一些数据到session对象上,用于session验证
					
					session.setAttribute("user", user);
					
					response.sendRedirect("main.jsp");
				}else{
					//登录失败,提示
					request.setAttribute("login_error", "用户名或者密码错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}catch(Exception e){
				
			}
		}
	}

}
