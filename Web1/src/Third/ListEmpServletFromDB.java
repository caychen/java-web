package Third;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListEmpServletFromDB extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out = response.getWriter();

		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", 
					"root", "Cam20150916");
		
			String sql = "select * from t_emp;";
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			
			out.println("<table border='1' width='60%'"
					+ "cellspacing='0' cellpadding='0'");
			out.println("<tr>"
					+ "<td>id</td>"
					+ "<td>姓名</td>"
					+ "<td>薪水</td>"
					+ "<td>年龄</td>"
					+ "<td>操作</td>"
					+ "</tr>");
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				
				out.println("<tr>"
						+ "<td>" + id + "</td>"
						+ "<td>" + name + "</td>"
						+ "<td>" + salary + "</td>"
						+ "<td>" + age + "</td>"
						+ "<td><a href='del?id=" + id + "'>删除</a>"
								+ "&nbsp<a href='load?id=" + id + "'>修改</a></td>"
						+ "</tr>");
			}
			out.println("</table>");
			out.println("<a href='addEmp4.html'>添加员工</a>");
			
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
				if(rs != null)
					rs.close();
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
