package test;

public class BMW implements Car{
	String name;
	@Override
	public void turnOn() {
		System.out.println(this.name+"와아아앙!");
	}

	@Override
	public void turnOff() {
		System.out.println(this.name+"슈우웅...");		
	}

	@Override
	public void speedUp() {
		System.out.println(this.name+"가속!");
	}

	@Override
	public void speedDown() {
		System.out.println(this.name+"감속..");		
	}

	@Override
	public void flex() {
		this.name = "BMW";
		System.out.println("내 차는 "+this.name+"다!");
	}

	@Override
	public void refillGas() {
		System.out.println(this.name+"에 기름넣기!");
	}

}
