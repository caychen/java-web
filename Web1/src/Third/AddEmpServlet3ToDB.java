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
		
		// ���ύʱ����Ҫ�Ա��е����ݽ��м�飬�����ݵĺϷ��ԡ�
		// �ͻ���ʹ��javascript��֤��������ʹ��servlet��֤
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
				out.println("���ʧ��.");
			else
				out.println("��ӳɹ�.");
		
			//ʹ�ó����Ӻ�jsʵ�ַ���
//			out.println("<br/><span style='color:red;' id='minutes'>5</span>��󷵻�,����������ת������<a href='ListEmpFromDB' style='font-style:italic;' onclick='endTimer();'>����</a>");
			
			//ʹ���ض���ʵ��"��������"����
			response.sendRedirect("ListEmpFromDB");
			
			/**
			 * a���ض���֮ǰ����Ҫ����out.close������
			 * b���ض���֮ǰ���������������response����Ļ�������ݡ�
			 */
			out.println("</body></html>");
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
