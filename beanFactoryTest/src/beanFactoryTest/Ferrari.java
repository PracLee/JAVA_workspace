package beanFactoryTest;

public class Ferrari implements Car{
	String name = "Ferrari";
	@Override
	public void turnOn() {
		System.out.println(this.name+"�ο;ƾƾ�!");
	}

	@Override
	public void turnOff() {
		System.out.println(this.name+"�ǽ����...");		
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
