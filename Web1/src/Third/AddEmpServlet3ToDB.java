package Third;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddEmpServlet3ToDB extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		
		// 表单提交时，需要对表单中的数据进行检查，看数据的合法性。
		// 客户端使用javascript验证，服务器使用servlet验证
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html><head>"
				+ "<script type='text/javascript' language='javascript' src='goto.js'></script>"
				+ "</head>");
		out.println("<body onload='startTimer();'>");

		Connection conn = null;
		PreparedStatement state = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", 
					"root", "Cam20150916");
			
			String sql = "insert into t_emp(name,salary,age) values(?,?,?)";

			state = conn.prepareStatement(sql);
			state.setString(1, name);
			state.setDouble(2, Double.parseDouble(salary));
			state.setInt(3, Integer.parseInt(age));
			
			if(state.executeUpdate() < 0)
				out.println("添加失败.");
			else
				out.println("添加成功.");
		
			//使用超链接和js实现返回
//			out.println("<br/><span style='color:red;' id='minutes'>5</span>秒后返回,如需立即跳转，请点击<a href='ListEmpFromDB' style='font-style:italic;' onclick='endTimer();'>这里</a>");
			
			//使用重定向实现"立即返回"操作
			response.sendRedirect("ListEmpFromDB");
			
			/**
			 * a、重定向之前，不要调用out.close方法。
			 * b、重定向之前，服务器会先清空response对象的缓存的数据。
			 */
			out.println("</body></html>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*
			 * 异常发生之后，首先记录日志，一般会将日志记录到文件里，可以用一些日志工具，比如log4j来记录。
			 * 接下来，看异常能否恢复，如果能，则编写处理代码，如果不能，则提示用户稍后重试
			 * 一般来说，系统异常是不能恢复的，所谓系统异常，指的是不是因为程序的原因产生的异常
			 * 			比如：数据库服务停止，连接数据库的网络中断等等。
			 */

			out.println("系统繁忙，稍后重试");
		} finally {
			try {
				if(state != null)
					state.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 也可以不调用close方法，因为service方法执行完毕后，容器会自动关闭调用out.close()方法
		out.close();
	}

}
