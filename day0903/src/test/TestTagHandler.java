package test;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestTagHandler extends SimpleTagSupport{
	
	
	// 실제 태그의 기능을 정의하는 메소드
	// 시작태그를 만나면 호출됨
	public void doTag() throws IOException {	
		// JSP로 부터 정보를 받아올수 있게 하는 메소드
		// getOut() : out객체를 참조할때 사용
		JspWriter out = getJspContext().getOut();
		out.println("태그 핸들러 클래스기반 실습중!");
	}
	
}
