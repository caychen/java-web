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

	private int count = 0;//������
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
     * session���󴴽�֮�����������HttpSessionEvent�¼���Ȼ�����sessionCreated����
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
     * session��������֮�����������HttpSessionEvent�¼���Ȼ�����sessionDestroyed����
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("sessionDestroyed...");
    	count--;
    	
    	//ͨ���¼������ҵ�session
    	HttpSession session = arg0.getSession();
    	ServletContext sc = session.getServletContext();
    	sc.setAttribute("count", count);
    }
	
}
