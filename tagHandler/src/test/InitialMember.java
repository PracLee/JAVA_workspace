package test;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitialMember implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// DB�����͸� ����
		// ->Member.java
		ArrayList<Member> datas = new ArrayList();
		for(int i = 1;i<=5;i++) {
			Member data = new Member("Ƽ��"+i,"timo"+i+"@naver.com");
			datas.add(data);
		}
		datas.add(new Member("������",null));
		datas.add(new Member("�ƹ���",null));

		// ���� ���� �����͵��� ��Ĺ�� ���۵ɶ� ������
		// scope: application�� �����ϰ� �ʹ�!
		ServletContext context= sce.getServletContext();
		context.setAttribute("members", datas);	//���ø�ĳ�̼ǿ� ����
		context.setAttribute("member", new Member());	//���ø�ĳ�̼ǿ� ����

	}

}