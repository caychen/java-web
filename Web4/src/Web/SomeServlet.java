package Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("uri:" + uri);
		if ("/Web4/list.do".equals(uri)) {
			System.out.println("list....");
		} else if ("/Web4/add.do".equals(uri)) {
			System.out.println("add...");
		} else if ("/Web4/del.do".equals(uri)) {
			System.out.println("del...");
		}
	}
}
