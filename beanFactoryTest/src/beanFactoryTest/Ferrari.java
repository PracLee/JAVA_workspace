package beanFactoryTest;

public class Ferrari implements Car{
	String name = "Ferrari";
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

}
