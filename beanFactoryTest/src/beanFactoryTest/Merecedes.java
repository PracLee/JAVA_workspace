			package beanFactoryTest;

public class Merecedes implements Car{
	String name = "Benz";
	@Override
	public void turnOn() {
		System.out.println(this.name+"�;ƾƾ�!");
	}

	@Override
	public void turnOff() {
		System.out.println(this.name+"�����...");		
	}

	@Override
	public void speedUp() {
		System.out.println(this.name+"����!");
	}

	@Override
	public void speedDown() {
		System.out.println(this.name+"����..");		
	}

	@Override
	public void flex() {
		System.out.println("�� ���� "+this.name+"��!");
	}

}
