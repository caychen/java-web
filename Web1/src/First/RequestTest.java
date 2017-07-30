package First;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 获取请求参数值
		String printCount = request.getParameter("printCount");
		String uname = request.getParameter("uname");

		int count = Integer.parseInt(printCount);

		// 处理请求,生成处理结果
		String rs = "";
		for (int i = 0; i < count; ++i) {
			rs += "<div>你好，" + uname + "!</div>";
		}

		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out = response.getWriter();

		out.println(rs);
		out.close();
	}
}