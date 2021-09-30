package test;

public class IPhone implements Phone{
	public IPhone() {
		System.out.println("Android 기본생성자 호출됨!");
	}
	@Override
	public void power() {
		System.out.println("Iphone 전원!");
	}

	@Override
	public void soundUp() {
		System.out.println("Iphone 소리업!");
	}

	@Override
	public void soundDown() {
		System.out.println("Iphone 소리다운!");
	}

}
