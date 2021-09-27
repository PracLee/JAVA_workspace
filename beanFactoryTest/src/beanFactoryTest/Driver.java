package beanFactoryTest;


public class Driver {
	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		Car car = (Car)factory.getBean(args[0]);
		car.turnOn();
		car.speedUp();
		car.speedDown();
		car.turnOff();
		car.flex();
	}
}
