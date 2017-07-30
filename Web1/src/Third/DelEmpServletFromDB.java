package Third;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBUtils;

public class DelEmpServletFromDB extends HttpServlet {

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
			PreparedStatement state = conn.prepareStatement("delete from t_emp where id=?");
			state.setInt(1, id);
			
			state.executeUpdate();
			
			response.sendRedirect("ListEmpFromDB");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("系统繁忙，稍后重试.");
		}finally{
			DBUtils.closeConnection(conn);
		}
	}
}
