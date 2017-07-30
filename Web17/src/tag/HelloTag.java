package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author 木石前盟Cam
 *
 *	标签类：
 *		1、继承SimpleTagSupport
 *		2、override doTag方法
 *		3、标签有哪些属性，则标签类就有哪些属性，且类型必须匹配
 *			此外这些属性必须提供相应的set方法。
 */
public class HelloTag extends SimpleTagSupport {
	private String msg;
	private int count;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		//通过SimpleTagSupport的getJspContext方法获取PageContext对象
		PageContext pct = (PageContext) getJspContext();
		
		JspWriter out = pct.getOut();
		for(int i = 0;i < count;++i){
			out.println(msg + "<br/>");
		}
	}
}
