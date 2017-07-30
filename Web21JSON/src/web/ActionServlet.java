package web;

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
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
	
		if(action.equals("quoto")){
			
			//模拟生成八支股票的价格信息，然后将这些信息转换成json字符串并发送给客户端
			List<Stock> stocks = new ArrayList<Stock>();
			Random r = new Random();
			DecimalFormat df = new DecimalFormat("#.##");
			for(int i = 0;i < 8;++i){
				Stock s = new Stock();
				s.setName("股票" + (i + 1));
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
		}
		
		out.close();
	}

}
