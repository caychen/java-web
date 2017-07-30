package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.DBUtils;

public class LoadEmpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Connection conn = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from t_emp where id=?";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, id);
			
			ResultSet rs = state.executeQuery();
			
			if(rs.next())
			{
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				
				out.println("<form action='modify' method='post'>");
				out.println("id:" + id + "<br/>");
				out.println("姓名:<input type='text' name='name' value='" + name + "'/><br/>");
				out.println("工资:<input type='text' name='salary' value='" + salary + "'/><br/>");
				out.println("年龄:<input type='text' name='age' value='" + age + "'/><br/>");
				
				//使用hidden隐藏域将id传递给servlet
				out.println("<input type='hidden' name='id' value='" + id + "'/>");
				out.println("<input type='submit' value='确定' />");
				out.println("</form>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(conn);
		}
	}
}
