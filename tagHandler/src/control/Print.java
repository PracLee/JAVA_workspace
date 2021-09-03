package control;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Print extends SimpleTagSupport{
	private String fontSize;
	private String color;
	public void doTag() throws IOException, JspException {
		JspWriter out = getJspContext().getOut();
		JspFragment body = getJspBody();
		if(body!=null) {
			StringBuffer sb = new StringBuffer();
			sb.append("<p style= 'font-size:").append(fontSize).append("; color:").append(color).append(";'>");
			out.println(sb.toString());
			body.invoke(null);
			out.println("</p>");
		}
		
	}
	
	public String getFontSize() {
		return fontSize;
	}
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
