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
		// DB데이터를 생성
		// ->Member.java
		ArrayList<Member> datas = new ArrayList();
		for(int i = 1;i<=5;i++) {
			Member data = new Member("티모"+i,"timo"+i+"@naver.com");
			datas.add(data);
		}
		datas.add(new Member("베르너",null));
		datas.add(new Member("아무무",null));

		// 현재 만든 데이터들은 톰캣이 시작될때 생성됨
		// scope: application에 저장하고 싶다!
		ServletContext context= sce.getServletContext();
		context.setAttribute("members", datas);	//어플리캐이션에 저장
		context.setAttribute("member", new Member());	//어플리캐이션에 저장

	}

}
