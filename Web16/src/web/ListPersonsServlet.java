package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Person;

/**
 * Servlet implementation class ListPersonsServlet
 */
@WebServlet("/ListPersons")
public class ListPersonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListPersonsServlet() {
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
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; ++i) {
			Person p = new Person();
			p.setName("person" + i);
			p.setGender("m");
			persons.add(p);
		}
		request.setAttribute("persons", persons);
		request.getRequestDispatcher("a7.jsp").forward(request, response);
		
	}

}
