package Web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.DBUtils;

public class ModifyEmpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
		
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update t_emp set name=?,salary=?,age=? where id=?";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, name);
			state.setDouble(2, salary);
			state.setInt(3, age);
			state.setInt(4, id);
			
			state.executeUpdate();
			
			response.sendRedirect("ListEmpFromDB");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(conn);
		}
	}

}
