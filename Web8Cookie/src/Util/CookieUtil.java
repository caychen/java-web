package Util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	// ��Ϊʵ�ʲ���ʱ��Ӧ����
	private static String appname = "/Web8Cookie";
	
	/**
	 * addCookie�����cookie����Ҫ���Ǳ�������
	 * 
	 * @param name
	 *            ��cookie������
	 * @param value
	 *            ��cookie��ֵ
	 * @param response
	 *            ����Ӧ����
	 * @param age
	 *            ������ʱ��
	 * @throws UnsupportedEncodingException 
	 */
	public static void addCookie(HttpServletResponse response, String name,
			String value, int age) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLDecoder.decode(value,"utf-8"));
		
		c.setMaxAge(age);
		c.setPath(appname);
		response.addCookie(c);
	}
	
	/**
	 * ����ָ�����Ƶ�cookie
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static String findCookie(HttpServletRequest request, String cookieName){
		String value = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(cookieName)){
					value = cookie.getValue();
				}
			}
		}
		return value;
	}
	
	public static void delCookie(HttpServletResponse response, String cookieName){
		Cookie c = new Cookie(cookieName, "");
		c.setMaxAge(0);
		c.setPath(appname);
		response.addCookie(c);
	}
}
