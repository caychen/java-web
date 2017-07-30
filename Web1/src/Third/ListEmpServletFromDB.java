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
					+ "<td>����</td>"
					+ "<td>нˮ</td>"
					+ "<td>����</td>"
					+ "<td>����</td>"
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
						+ "<td><a href='del?id=" + id + "'>ɾ��</a>"
								+ "&nbsp<a href='load?id=" + id + "'>�޸�</a></td>"
						+ "</tr>");
			}
			out.println("</table>");
			out.println("<a href='addEmp4.html'>���Ա��</a>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*
			 * �쳣����֮�����ȼ�¼��־��һ��Ὣ��־��¼���ļ��������һЩ��־���ߣ�����log4j����¼��
			 * �����������쳣�ܷ�ָ�������ܣ����д������룬������ܣ�����ʾ�û��Ժ�����
			 * һ����˵��ϵͳ�쳣�ǲ��ָܻ��ģ���νϵͳ�쳣��ָ���ǲ�����Ϊ�����ԭ��������쳣
			 * 			���磺���ݿ����ֹͣ���������ݿ�������жϵȵȡ�
			 */

			out.println("ϵͳ��æ���Ժ�����");
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

		// Ҳ���Բ�����close��������Ϊservice����ִ����Ϻ��������Զ��رյ���out.close()����
		out.close();
	}

}
