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
		// step1����ͼ
		// 1������һ���ڴ�ӳ�����(����һ������)
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		// 2����û���
		Graphics g = image.getGraphics();
		// 3��������ɫ
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		// 4�����������ñ�����ɫ
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// 5���滭
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
		// ��number�󶨵�session������
		HttpSession session = request.getSession();
		session.setAttribute("number", number);

		g.setColor(new Color(0, 0, 0));
		// g.drawString(number, 15, 25);

		// ���������
		for (int i = 0; i < 5; ++i)
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80),
					r.nextInt(30));

		// step2��ͼƬѹ����Ȼ��������ͻ���(�����)
		// ����content-type��Ϣͷ��֪ͨ��������ص���һ��jpeg��ʽ��ͼƬ
		response.setContentType("img/jpeg");

		// ����ֽ������
		OutputStream output = response.getOutputStream();
		// ��imageͼƬ����ָ����ѹ����ʽ(jpeg)����ѹ����
		// Ȼ��ѹ�������ɵ�����ͨ��output�����response������
		// ���������response������ȡ�����ݣ���������������
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
