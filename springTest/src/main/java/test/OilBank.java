package test;

public class OilBank implements GasStation{
	String name;
	public OilBank() {
		this.name = "오일뱅크";
		System.out.println(this.name+" 찾았다!");
	}
	@Override
	public void refillGas() {
		System.out.println(this.name+"에서 기름넣자!");
	}

}
