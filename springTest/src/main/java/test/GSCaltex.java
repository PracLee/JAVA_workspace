package test;

public class GSCaltex implements GasStation {
	String name;
	public GSCaltex() {
		this.name = "GSĮ�ؽ�";
		System.out.println(this.name+" ã�Ҵ�!");
	}
	@Override
	public void refillGas() {
		System.out.println(this.name+"���� �⸧����!");
	}
}
