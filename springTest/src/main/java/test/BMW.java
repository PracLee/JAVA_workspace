package test;

public class BMW implements Car{
	String name;
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
		this.name = "BMW";
		System.out.println("�� ���� "+this.name+"��!");
	}

	@Override
	public void refillGas() {
		System.out.println(this.name+"�� �⸧�ֱ�!");
	}

}
