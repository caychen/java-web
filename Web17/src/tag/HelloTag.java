package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author ľʯǰ��Cam
 *
 *	��ǩ�ࣺ
 *		1���̳�SimpleTagSupport
 *		2��override doTag����
 *		3����ǩ����Щ���ԣ����ǩ�������Щ���ԣ������ͱ���ƥ��
 *			������Щ���Ա����ṩ��Ӧ��set������
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
		//ͨ��SimpleTagSupport��getJspContext������ȡPageContext����
		PageContext pct = (PageContext) getJspContext();
		
		JspWriter out = pct.getOut();
		for(int i = 0;i < count;++i){
			out.println(msg + "<br/>");
		}
	}
}
