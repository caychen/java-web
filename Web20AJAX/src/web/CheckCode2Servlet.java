package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckCode2Servlet
 */
@WebServlet("/CheckCode2")
public class CheckCode2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int WIDTH = 80;
	private static int HEIGHT = 30;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckCode2Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// step1、绘图
		// 1、创建一个内存映像对象(类似一个画布)
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		// 2、获得画笔
		Graphics g = image.getGraphics();
		// 3、给笔上色
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		// 4、给画布设置背景颜色
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// 5、绘画
		// String number = r.nextInt(99999) + "";
		String number = "";
		for (int i = 0; i < 4; ++i) {
			int h = (int) (20 * r.nextDouble() + 10);
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			String ch = getNumber(1);
			number += ch;
			g.setFont(new Font(null, Font.ITALIC | Font.BOLD, h));
			g.drawString(ch, WIDTH / 5 * i, h);
		}
		// 将number绑定到session对象上
		HttpSession session = request.getSession();
		session.setAttribute("number", number);

		g.setColor(new Color(0, 0, 0));
		// g.drawString(number, 15, 25);

		// 加入干扰线
		for (int i = 0; i < 5; ++i)
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80),
					r.nextInt(30));

		// step2、图片压缩，然后输出到客户端(浏览器)
		// 设置content-type消息头，通知浏览器返回的是一个jpeg格式的图片
		response.setContentType("img/jpeg");

		// 获得字节输出流
		OutputStream output = response.getOutputStream();
		// 将image图片按照指定的压缩格式(jpeg)进行压缩，
		// 然后将压缩后生成的数据通过output输出到response对象上
		// 服务器会从response对象上取出数据，打包发给浏览器。
		ImageIO.write(image, "jpeg", output);

	}

	private String getNumber(int size) {
		// TODO Auto-generated method stub
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890";
		String rs = "";
		Random r = new Random();
		for (int i = 0; i < size; ++i) {
			rs += str.charAt(r.nextInt(str.length()));
		}
		return rs;
	}

}
