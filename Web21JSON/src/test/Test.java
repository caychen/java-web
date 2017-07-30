package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.Stock;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock stock = new Stock();
		stock.setName("告诉");
		stock.setCode("600015");
		stock.setPrice(12.7);
		
		//得到一个json对象
		JSONObject obj = JSONObject.fromObject(stock);
		String jsonStr = obj.toString();
		System.out.println(jsonStr);
		
		test2();
	}
	
	//将java对象组成的数组或者列表转换成json对象
	public static void test2(){
		List<Stock> stocks = new ArrayList<Stock>();
		Random r = new Random();
		DecimalFormat df = new DecimalFormat("#.##");
		for(int i = 0;i < 3;++i)
		{
			Stock s = new Stock();
			s.setName("高速" + r.nextInt(10));
			s.setCode("60000" + r.nextInt(10));
			
			double price = r.nextInt(100) + r.nextDouble();
			s.setPrice(Double.parseDouble(df.format(price)));
			stocks.add(s);
		}
		
		JSONArray arr = JSONArray.fromObject(stocks);
		String jsonStr = arr.toString();
		System.out.println(jsonStr);
	}

}
