package test;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import model.DataBean;

public class MsgTagHandler extends SimpleTagSupport {
	private String bgcolor;
	private String border;

	public void doTag() throws IOException, JspException {

		JspWriter out = getJspContext().getOut();
		DataBean db = new DataBean();
		JspFragment body = getJspBody();	//jsp에 body를 가져오는 객체
		if(body!=null) {	// 만약에 태그 바디가 있다면
			out.println("<h1>");
			body.invoke(null);	// 바디 태그 안에 다시 넣기
			out.println("</h1>");
		}
		// 스트링 버퍼를 이용해보자!
		StringBuffer sb=new StringBuffer();
		sb.append("<table border=").append(border).append(" bgcolor=").append(bgcolor).append(">");	// 여러번 수행할것을
		out.println(sb.toString());	// 저장하여 한번에 수행
		for(String v : db.getDataList()) {
			out.println("<tr><td>"+v+"</td></tr>");
		}
		out.println("</table>");
	}
	public String getBgcolor() {
		return bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}
	public String getBorder() {
		return border;
	}
	public void setBorder(String border) {
		this.border = border;
	}

}
