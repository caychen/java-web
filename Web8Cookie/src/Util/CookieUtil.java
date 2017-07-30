package Util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	// 改为实际部署时的应用名
	private static String appname = "/Web8Cookie";
	
	/**
	 * addCookie：添加cookie，需要考虑编码问题
	 * 
	 * @param name
	 *            ：cookie的名称
	 * @param value
	 *            ：cookie的值
	 * @param response
	 *            ：响应对象
	 * @param age
	 *            ：生存时间
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
	 * 查找指定名称的cookie
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
