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
		
		try {
			EmployeeDAO dao = (EmployeeDAO) Factory.getInstance("EmployeeDAO");
			
			Employee emp = dao.findById(id);
			
			if(emp != null)
			{
				String name = emp.getName();
				double salary = emp.getSalary();
				int age = emp.getAge();
				
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
		}
	}
}
