package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.impl.EmployeeDAOJdbcImpl;
import entity.Employee;

public class ListEmpServletFromDB extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out = response.getWriter();

		try {
			//ʹ��DAO���������ݿ�
			EmployeeDAO dao = new EmployeeDAOJdbcImpl();
			List<Employee> emps = dao.findAll();
			
			out.println("<table border='1' width='60%'"
					+ "cellspacing='0' cellpadding='0'");
			out.println("<tr>"
					+ "<td>id</td>"
					+ "<td>����</td>"
					+ "<td>нˮ</td>"
					+ "<td>����</td>"
					+ "<td>����</td>"
					+ "</tr>");
			
			for (Employee employee : emps) {
				int id = employee.getId();
				String name = employee.getName();
				double salary = employee.getSalary();
				int age = employee.getAge();
				
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
	
		}

		// Ҳ���Բ�����close��������Ϊservice����ִ����Ϻ��������Զ��رյ���out.close()����
		out.close();
	}

}
