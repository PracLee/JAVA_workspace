package model.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class MemberClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		MemberService ms = (MemberService)factory.getBean("mService");
		System.out.println(ms.selectAll());
		factory.close();
	}
}
