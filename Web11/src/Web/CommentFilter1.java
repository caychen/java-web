package Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CommentFilter
 */
@WebFilter("/CommentFilter1")
public class CommentFilter1 implements Filter {

	private FilterConfig config;
	/**
	 * Default constructor.
	 */
	public CommentFilter1() {
		// TODO Auto-generated constructor stub
		System.out.println("Constructor...");
	}

	/**
	 * @see Filter#destroy()
	 */
	//���������ٹ���������֮ǰ������ø÷�����ִֻ��һ��
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	/**
	 * ���������doFilter����������������������������servlet��service����һ����
	 * 
	 * FilterChain:��������
	 * �������FilterChain��doFilter������������������ú����Ĺ���������servlet
	 * ���û�е���FilterChain��doFilter����������������������
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("DoFilter...");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String content = req.getParameter("content");
		PrintWriter out = res.getWriter();
		
		String illegalStr = config.getInitParameter("illegalStr");
		
		if(content.indexOf(illegalStr) != -1){
			//�������֣���ʾ�û����۵�����������
			out.println("<h1>���۵�����������!</h1>");
		}else{
			// pass the request along the filter chain
			//��������
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		/*
		 * ����������ʱ���ᴴ�����������󣬻���������init������ɳ�ʼ������,�÷���ֻ����һ�Ρ�
		 * ���������ȴ�����һ������FilterConfig�ӿ�Ҫ��Ķ���
		 * ����ͨ��FilterConfig.getInitParameter���������ʹ������ĳ�ʼ������
		 */	
		System.out.println("Init...");
		config = fConfig;
	}

}
