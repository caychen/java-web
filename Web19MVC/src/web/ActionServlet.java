package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Person;
import service.AccountLimitException;
import service.AccountNotExistException;
import service.AccountService;
import service.PersonService;

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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/") + 1,
				uri.lastIndexOf("."));

		if(action.equals("to_apply")){
			request.getRequestDispatcher("WEB-INF/jsp/apply.jsp").forward(request, response);
		}else if(action.equals("to_bmi")){
			request.getRequestDispatcher("WEB-INF/jsp/bmi.jsp").forward(request, response);
		}
		
		if (action.equals("apply")) {
			String accountNo = request.getParameter("accountNo");
			double amount = Double.parseDouble(request.getParameter("amount"));

			AccountService service = new AccountService();
			try {
				String number = service.apply(accountNo, amount);
				// 依据模型的返回结果来选择合适的视图
				request.setAttribute("number", "贷款申请成功，请记住序列号:" + number);
				request.getRequestDispatcher("WEB-INF/jsp/view.jsp").forward(request,
						response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				// 应用异常
				if (e instanceof AccountNotExistException) {
					request.setAttribute("apply_error", "帐号不存在");
					request.getRequestDispatcher("WEB-INF/jsp/apply.jsp").forward(request,
							response);
				} else if (e instanceof AccountLimitException) {
					request.setAttribute("apply_error", "余额不足");
					request.getRequestDispatcher("WEB-INF/jsp/apply.jsp").forward(request,
							response);
				} else {// 系统异常
					throw new ServletException(e);
				}
			}

		} else if (action.equals("calc")) {
			String gender = request.getParameter("gender");
			double height = Double.parseDouble(request.getParameter("height"));
			double weight = Double.parseDouble(request.getParameter("weight"));
			Person person = new Person();
			person.setGender(gender);
			person.setHeight(height);
			person.setWeight(weight);

			PersonService ps = new PersonService();
			try {
				String result = ps.BMICalculate(person);
				request.setAttribute("result", "您的体质指数为: " + result);
				request.getRequestDispatcher("WEB-INF/jsp/result.jsp").forward(request,
						response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
	}

}
