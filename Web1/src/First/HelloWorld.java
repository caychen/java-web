package First;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		response.setCharacterEncoding("utf-8");//���ñ����ʽ
		//������content-type�м���charset=utf-8;
		
		//������Ϣͷcontent-type��������������ص���һ��html�ĵ��Լ������ʽ
		response.setContentType("text/html;charset=utf-8;");
		
		//���һ�������
		PrintWriter out = response.getWriter();
		
		//�������ķ�ʽ�����������ʵ���ǽ�������д����response������
		out.println("<h2 style='color:red;'>Hello World</h2>");
		out.println("<span style='color:red;'>�Ұ�����</span>");

		out.close();
	}

}
