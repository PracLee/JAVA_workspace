package test;

public class OilBank implements GasStation{
	String name;
	public OilBank() {
		this.name = "���Ϲ�ũ";
		System.out.println(this.name+" ã�Ҵ�!");
	}
	@Override
	public void refillGas() {
		System.out.println(this.name+"���� �⸧����!");
	}

}
