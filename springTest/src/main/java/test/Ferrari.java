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
		System.out.println(this.name+"부와아아앙!");
	}

	@Override
	public void turnOff() {
		System.out.println(this.name+"피슈우웅...");		
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
		System.out.println("내 차는 "+this.name+"다!");
	}

	@Override
	public void refillGas() {
		System.out.println(this.name+"에 기름넣기!");
	}

}
