package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		Phone p = (Phone)factory.getBean("phone");
		p.power();
		p.soundDown();
		p.soundUp();
		
		
		factory.close();
	}
}
