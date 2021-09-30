package test;

public class GSCaltex implements GasStation {
	String name;
	public GSCaltex() {
		this.name = "GS칼텍스";
		System.out.println(this.name+" 찾았다!");
	}
	@Override
	public void refillGas() {
		System.out.println(this.name+"에서 기름넣자!");
	}
}
