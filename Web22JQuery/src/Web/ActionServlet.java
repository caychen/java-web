package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import bean.Stock;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		//System.out.println(action);
		if(action.equals("priceInfo")){
			String airline = request.getParameter("airline");
			//System.out.println(airline);
			if(airline.equals("CA1000")){
				out.println("ͷ�Ȳ�:��2400<br/>�����:��2200");
			}else if(airline.equals("MU1494")){
				out.println("ͷ�Ȳ�:��2200<br/>�����:��2000");
			}
		}else if(action.equals("quoto")){
			//ģ�����ɰ�֧��Ʊ�ļ۸���Ϣ��Ȼ����Щ��Ϣת����json�ַ��������͸��ͻ���
			List<Stock> stocks = new ArrayList<Stock>();
			Random r = new Random();
			DecimalFormat df = new DecimalFormat("#.##");
			for(int i = 0;i < 8;++i){
				Stock s = new Stock();
				s.setName("��Ʊ" + (i + 1));
				s.setCode("60001" + r.nextInt(10));
				s.setPrice(Double.parseDouble(df.format(r.nextInt(100) + r.nextDouble())));
				stocks.add(s);
			}
			
			JSONArray arr = JSONArray.fromObject(stocks);
			out.println(arr.toString());
			//System.out.println(arr.toString());
		}else if(action.equals("check_username")){
			String username = request.getParameter("username");
			if(username.equals("zs")){
				out.print("error");
			}else
				out.print("ok");
		}else if(action.equals("search")){
			String key = request.getParameter("key");
			if(key.equals("С")){
				out.println("Сѧ������,С��,Сѧ���ֲ�,С��,С���ֻ�");
			}else if(key.equals("Сѧ")){
				out.println("Сѧ������,Сѧ���ֲ�");
			}
			
		}
	}

}
