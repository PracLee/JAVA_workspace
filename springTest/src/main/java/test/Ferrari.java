package test;

public class Ferrari implements Car{
	private String name;
	private GasStation station;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setStation(GasStation station) {
		this.station = station;
	}


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

	@Override
	public void refillGas() {
		System.out.println(this.name+"�� �⸧�ֱ�!");
	}

}
