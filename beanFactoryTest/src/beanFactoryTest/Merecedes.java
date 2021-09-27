			package beanFactoryTest;

public class Merecedes implements Car{
	String name = "Benz";
	@Override
	public void turnOn() {
		System.out.println(this.name+"¿Í¾Æ¾Æ¾Ó!");
	}

	@Override
	public void turnOff() {
		System.out.println(this.name+"½´¿ì¿õ...");		
	}

	@Override
	public void speedUp() {
		System.out.println(this.name+"°¡¼Ó!");
	}

	@Override
	public void speedDown() {
		System.out.println(this.name+"°¨¼Ó..");		
	}

	@Override
	public void flex() {
		System.out.println("³» Â÷´Â "+this.name+"´Ù!");
	}

}
