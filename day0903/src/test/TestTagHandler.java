package test;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestTagHandler extends SimpleTagSupport{
	
	
	// ���� �±��� ����� �����ϴ� �޼ҵ�
	// �����±׸� ������ ȣ���
	public void doTag() throws IOException {	
		// JSP�� ���� ������ �޾ƿü� �ְ� �ϴ� �޼ҵ�
		// getOut() : out��ü�� �����Ҷ� ���
		JspWriter out = getJspContext().getOut();
		out.println("�±� �ڵ鷯 Ŭ������� �ǽ���!");
	}
	
}
