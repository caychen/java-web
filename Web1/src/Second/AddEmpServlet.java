package Second;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		
		//���ύʱ����Ҫ�Ա��е����ݽ��м�飬�����ݵĺϷ��ԡ�
		//�ͻ���ʹ��javascript��֤��������ʹ��servlet��֤
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println(name + " " + salary + " " + age);
		
		//Ҳ���Բ�����close��������Ϊservice����ִ����Ϻ��������Զ��رյ���out.close()����
		out.close();
	}

}
