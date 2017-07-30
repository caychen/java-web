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
		
		//ͨ��GenericServlet�ṩ�ķ��������ServletConfig����
		ServletConfig config = getServletConfig();
		
		//����ͨ��ServletConfig����������Servlet�ĳ�ʼ������
		//��web.xml��ʹ��<servlet><init-param></init-param></servlet>
		
		System.out.println("LifeServlet's service...");
		String country = config.getInitParameter("Country");
		String city = config.getInitParameter("City");
		System.out.println(country + "," + city);
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
		System.out.println("�����ṩ��init�߼�...");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//super.destroy();
		System.out.println("Servlet��������...");
	}

}
