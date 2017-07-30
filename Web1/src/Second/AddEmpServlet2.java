package Second;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet2 extends HttpServlet {

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
		String[] hobbies = request.getParameterValues("hobby");
		
		//���ύʱ����Ҫ�Ա��е����ݽ��м�飬�����ݵĺϷ��ԡ�
		//�ͻ���ʹ��javascript��֤��������ʹ��servlet��֤
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String s = name + " " + salary + " " + age;
		for (String hobby : hobbies) {
			s += hobby + " ";
		}
		out.println(s);
		
		//Ҳ���Բ�����close��������Ϊservice����ִ����Ϻ��������Զ��رյ���out.close()����
		out.close();
	}

}
