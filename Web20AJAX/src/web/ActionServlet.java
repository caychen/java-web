package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/") + 1,uri.lastIndexOf("."));
		
		if(action.equals("check_username")){
			String username = request.getParameter("username");
			if(username.equals("zs")){
				out.println("�û�����ռ��");
			}else{
				out.println("����ʹ��");
			}
		}else if(action.equals("check_code")){
			String number = request.getParameter("number");
			String numberSession = (String) request.getSession().getAttribute("number");
			//System.out.println(number + "," + numberSession);
			if(number.equalsIgnoreCase(numberSession)){
				out.println("��֤����ȷ");
			}else{
				out.println("��֤�����");
			}
		}else if(action.equals("getNumber")){
			Random r = new Random();
			int number = r.nextInt();
			System.out.println(number);
			
			out.println(number);
		}
	}

}
