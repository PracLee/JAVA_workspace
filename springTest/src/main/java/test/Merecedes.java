package test;

public class Merecedes implements Car{
	String name;
	GasStation gs;
	public Merecedes() {
		System.out.println("Meresedes �⺻������ ȣ��!");
	}
	public Merecedes(GasStation gs) {
		this.gs = gs;
		System.out.println("Meresedes ������ ȣ��!");
	}
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
		this.name = "merecedes";
		System.out.println("�� ���� "+this.name+"��!");
	}

	@Override
	public void refillGas() {
		gs.refillGas();
		//System.out.println(this.name+"�� �⸧�ֱ�!");
	}

}
