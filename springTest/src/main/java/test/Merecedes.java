package test;

public class Merecedes implements Car{
	String name;
	GasStation gs;
	public Merecedes() {
		System.out.println("Meresedes 기본생성자 호출!");
	}
	public Merecedes(GasStation gs) {
		this.gs = gs;
		System.out.println("Meresedes 생성자 호출!");
	}
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
		this.name = "merecedes";
		System.out.println("내 차는 "+this.name+"다!");
	}

	@Override
	public void refillGas() {
		gs.refillGas();
		//System.out.println(this.name+"에 기름넣기!");
	}

}
