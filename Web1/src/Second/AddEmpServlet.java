package Second;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		
		//表单提交时，需要对表单中的数据进行检查，看数据的合法性。
		//客户端使用javascript验证，服务器使用servlet验证
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println(name + " " + salary + " " + age);
		
		//也可以不调用close方法，因为service方法执行完毕后，容器会自动关闭调用out.close()方法
		out.close();
	}

}
