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
		// ��ȡ�������ֵ
		String printCount = request.getParameter("printCount");
		String uname = request.getParameter("uname");

		int count = Integer.parseInt(printCount);

		// ��������,���ɴ�����
		String rs = "";
		for (int i = 0; i < count; ++i) {
			rs += "<div>��ã�" + uname + "!</div>";
		}

		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out = response.getWriter();

		out.println(rs);
		out.close();
	}
}