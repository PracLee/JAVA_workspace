package test;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		Car car = (Car)factory.getBean("ferrari");
		car.turnOn();
		car.speedUp();
		car.speedDown();
		car.turnOff();
		car.refillGas();
		CBean cb = (CBean)factory.getBean("cb");
		List<String> list = cb.getList();
		System.out.println("네비게이션 목록");
		for(String v : list) {
			System.out.println(v);
		}
		factory.close();
	}
}
