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
				// 使用DAO来访问数据库

				List<Employee> emps = dao.findAll();

				// 转发
				// step1、绑定数据
				request.setAttribute("employees", emps);

				// step2、获得转发器
				RequestDispatcher rd = request
						.getRequestDispatcher("listEmp.jsp");

				// step3、转发
				rd.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				/*
				 * 异常发生之后，首先记录日志，一般会将日志记录到文件里，可以用一些日志工具，比如log4j来记录。
				 * 接下来，看异常能否恢复，如果能，则编写处理代码，如果不能，则提示用户稍后重试
				 * 一般来说，系统异常是不能恢复的，所谓系统异常，指的是不是因为程序的原因产生的异常
				 * 比如：数据库服务停止，连接数据库的网络中断等等。
				 */
				
				//利用转发的方式来处理异常
//				request.setAttribute("syserror", "系统繁忙，稍后重试");
//				request.getRequestDispatcher("error.jsp").forward(request, response);
				
				//也可以将异常抛给容器，让容器来处理
				throw new ServletException(e);
			}

			// 也可以不调用close方法，因为service方法执行完毕后，容器会自动关闭调用out.close()方法

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
//				request.setAttribute("syserror", "系统繁忙，稍后重试");
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
//				request.setAttribute("syserror", "系统繁忙，稍后重试");
//				request.getRequestDispatcher("error.jsp").forward(request, response);
				
				throw new ServletException(e);
			}
		} else if (action.equals("/modify")) {
			int id = Integer.parseInt(request.getParameter("id"));

			try {
				Employee emp = dao.findById(id);

				// 转发
				request.setAttribute("employee", emp);
				request.getRequestDispatcher("modifyEmp.jsp").forward(request,
						response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//				request.setAttribute("syserror", "系统繁忙，稍后重试");
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
//				request.setAttribute("syserror", "系统繁忙，稍后重试");
//				request.getRequestDispatcher("error.jsp").forward(request, response);
				
				throw new ServletException(e);
			}
		}

	}

}
