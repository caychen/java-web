package Web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LifeServlet()
	{
		System.out.println("LifeServlet's constructor...");
	}
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//通过GenericServlet提供的方法来获得ServletConfig对象
		ServletConfig config = getServletConfig();
		
		//可以通过ServletConfig对象来访问Servlet的初始化参数
		//在web.xml中使用<servlet><init-param></init-param></servlet>
		
		System.out.println("LifeServlet's service...");
		String country = config.getInitParameter("Country");
		String city = config.getInitParameter("City");
		System.out.println(country + "," + city);
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
		System.out.println("我们提供的init逻辑...");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//super.destroy();
		System.out.println("Servlet正在销毁...");
	}

}
