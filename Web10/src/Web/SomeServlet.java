package Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SomeServlet
 */
@WebServlet("/Some")
public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SomeServlet() {
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
		request.setCharacterEncoding("utf-8");

		// 获得session对象
		HttpSession session = request.getSession();
		
		//设置超时限制为30s
		session.setMaxInactiveInterval(30);
		
		String sessionId = session.getId();
		System.out.println("SessionId:" + sessionId);
		Integer count = (Integer) session.getAttribute("count");
		if (count == null) {
			// 第一次访问，则count设置为1
			count = 1;
		} else {
			//不是第一次访问，在原有值的基础上加1
			count++;
		}
		session.setAttribute("count", count);
		out.println("<h1>你是第" + count + "次访问！</h1>");
		
		//立即删除session对象
		session.invalidate();

		out.close();
	}

}
