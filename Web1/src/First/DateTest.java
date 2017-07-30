package First;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateTest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		Date d = new Date();
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
		String s = df.format(d);
		
		PrintWriter out = response.getWriter();
		out.println("<h2>now£º"
				+ s
				+ "</h2>");
		
		out.close();
	}

}
