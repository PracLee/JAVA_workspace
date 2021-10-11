package model.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class MemberClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		MemberService ms=(MemberService)factory.getBean("mService");

		MemberVO vo=new MemberVO();
		vo.setId("add");
		vo.setPw("1234");
		MemberVO data = ms.selectOne(vo);

		if(data!=null) {
			// �α��� ����
			System.out.println("�α��� ����!");
		}
		else {
			// �α��� ����
			System.out.println("�α��� ����!");
		}

		factory.close();
	}
}
