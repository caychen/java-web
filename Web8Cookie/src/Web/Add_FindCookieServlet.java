package Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add_FindCookieServlet
 */
@WebServlet("/Add_FindCookie")
public class Add_FindCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Add_FindCookieServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		boolean isFind = false;
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie2 : cookies) {
				if(cookie2.getName().equals("username")){
					out.println("username :" + cookie2.getName() + " value:" + cookie2.getValue());
					isFind = true;
					break;
				}
			}
		}
		if(cookies == null || !isFind){
			Cookie cookie = new Cookie("username", "zs");
			response.addCookie(cookie);
		}
		out.close();
	}

}
