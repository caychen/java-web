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
	//容器在销毁过滤器对象之前，会调用该方法，只执行一次
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	/**
	 * 容器会调用doFilter方法来处理请求，类似于容器调用servlet的service方法一样。
	 * 
	 * FilterChain:过滤器链
	 * 如果调用FilterChain的doFilter方法，容器会继续调用后续的过滤器或者servlet
	 * 如果没有调用FilterChain的doFilter方法，则容器不再向后调用
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
			//有敏感字，提示用户评论当中有敏感字
			out.println("<h1>评论当中有敏感字!</h1>");
		}else{
			// pass the request along the filter chain
			//无敏感字
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		/*
		 * 容器在启动时，会创建过滤器对象，会立即调用init方法完成初始化操作,该方法只调用一次。
		 * 容器会事先创建好一个符合FilterConfig接口要求的对象。
		 * 可以通过FilterConfig.getInitParameter方法来访问过滤器的初始化参数
		 */	
		System.out.println("Init...");
		config = fConfig;
	}

}
