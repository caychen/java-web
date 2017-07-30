package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCookieServlet
 */
@WebServlet("/AddCookie")
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCookieServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		Cookie c1 = new Cookie("username", "cam");
		response.addCookie(c1);
		Cookie c2 = new Cookie("city", "jiangsu");
		response.addCookie(c2);
		
		//中文需要转码
		Cookie c3 = new Cookie("name", URLEncoder.encode("宝贝", "utf-8"));
		response.addCookie(c3);
		
		Cookie c4 = new Cookie("sex", "male");
		c4.setMaxAge(40);
		response.addCookie(c4);//存放在硬盘上，40s后消失
		out.println("<h1>添加cookie成功...</h1>");
		out.close();
	}

}
