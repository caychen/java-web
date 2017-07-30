package Web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.Factory;
import dao.EmployeeDAO;
import entity.Employee;


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

		
		try {
			EmployeeDAO dao = (EmployeeDAO) Factory.getInstance("EmployeeDAO");
			
			Employee emp = new Employee();
			emp.setName(name);
			emp.setSalary(Double.parseDouble(salary));
			emp.setAge(Integer.parseInt(age));
			
			dao.addEmp(emp);
			
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
		}
		// Ҳ���Բ�����close��������Ϊservice����ִ����Ϻ��������Զ��رյ���out.close()����
		out.close();
	}

}
