package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.Factory;
import dao.EmployeeDAO;
import entity.Employee;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=utf-8;");
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));

		EmployeeDAO dao = (EmployeeDAO) Factory.getInstance("EmployeeDAO");

		if (action.equals("/list")) {
			try {
				// ʹ��DAO���������ݿ�

				List<Employee> emps = dao.findAll();

				// ת��
				// step1��������
				request.setAttribute("employees", emps);

				// step2�����ת����
				RequestDispatcher rd = request
						.getRequestDispatcher("listEmp.jsp");

				// step3��ת��
				rd.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				/*
				 * �쳣����֮�����ȼ�¼��־��һ��Ὣ��־��¼���ļ��������һЩ��־���ߣ�����log4j����¼��
				 * �����������쳣�ܷ�ָ�������ܣ����д������룬������ܣ�����ʾ�û��Ժ�����
				 * һ����˵��ϵͳ�쳣�ǲ��ָܻ��ģ���νϵͳ�쳣��ָ���ǲ�����Ϊ�����ԭ��������쳣
				 * ���磺���ݿ����ֹͣ���������ݿ�������жϵȵȡ�
				 */
				
				//����ת���ķ�ʽ�������쳣
//				request.setAttribute("syserror", "ϵͳ��æ���Ժ�����");
//				request.getRequestDispatcher("error.jsp").forward(request, response);
				
				//Ҳ���Խ��쳣�׸�������������������
				throw new ServletException(e);
			}

			// Ҳ���Բ�����close��������Ϊservice����ִ����Ϻ��������Զ��رյ���out.close()����

		} else if (action.equals("/add")) {
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");

			Employee emp = new Employee();
			emp.setName(name);
			emp.setSalary(Double.parseDouble(salary));
			emp.setAge(Integer.parseInt(age));

			try {
				dao.addEmp(emp);

				response.sendRedirect("list.do");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//				request.setAttribute("syserror", "ϵͳ��æ���Ժ�����");
//				request.getRequestDispatcher("error.jsp").forward(request, response);
				
				throw new ServletException(e);
			}
		} else if (action.equals("/del")) {
			int id = Integer.parseInt(request.getParameter("id"));

			try {
				dao.deleteEmp(id);

				response.sendRedirect("list.do");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//				request.setAttribute("syserror", "ϵͳ��æ���Ժ�����");
//				request.getRequestDispatcher("error.jsp").forward(request, response);
				
				throw new ServletException(e);
			}
		} else if (action.equals("/modify")) {
			int id = Integer.parseInt(request.getParameter("id"));

			try {
				Employee emp = dao.findById(id);

				// ת��
				request.setAttribute("employee", emp);
				request.getRequestDispatcher("modifyEmp.jsp").forward(request,
						response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//				request.setAttribute("syserror", "ϵͳ��æ���Ժ�����");
//				request.getRequestDispatcher("error.jsp").forward(request, response);
				
				throw new ServletException(e);
			}
		} else if (action.equals("/comfirm")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));

			Employee emp = new Employee();
			emp.setId(id);
			emp.setName(name);
			emp.setSalary(salary);
			emp.setAge(age);

			try {
				dao.modifyEmp(emp);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//				request.setAttribute("syserror", "ϵͳ��æ���Ժ�����");
//				request.getRequestDispatcher("error.jsp").forward(request, response);
				
				throw new ServletException(e);
			}
		}

	}

}
