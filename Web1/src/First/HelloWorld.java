package First;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		response.setCharacterEncoding("utf-8");//设置编码格式
		//或者在content-type中加入charset=utf-8;
		
		//设置消息头content-type，告诉浏览器返回的是一个html文档以及编码格式
		response.setContentType("text/html;charset=utf-8;");
		
		//获得一个输出流
		PrintWriter out = response.getWriter();
		
		//调用流的方式进行输出，其实质是将处理结果写到了response对象上
		out.println("<h2 style='color:red;'>Hello World</h2>");
		out.println("<span style='color:red;'>我爱妳！</span>");

		out.close();
	}

}
