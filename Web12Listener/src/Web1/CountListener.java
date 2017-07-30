package Web1;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CountListener
 *
 */
@WebListener
public class CountListener implements HttpSessionListener {

	private int count = 0;//计数器
    /**
     * Default constructor. 
     */
    public CountListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    
    /**
     * session对象创建之后，容器会产生HttpSessionEvent事件，然后调用sessionCreated方法
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("sessionCreated...");
    	count++;
    	
    	HttpSession session = arg0.getSession();
    	ServletContext sc = session.getServletContext();
    	sc.setAttribute("count", count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    
    /**
     * session对象销毁之后，容器会产生HttpSessionEvent事件，然后调用sessionDestroyed方法
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("sessionDestroyed...");
    	count--;
    	
    	//通过事件对象找到session
    	HttpSession session = arg0.getSession();
    	ServletContext sc = session.getServletContext();
    	sc.setAttribute("count", count);
    }
	
}
