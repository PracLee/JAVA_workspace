package test;

public class IPhone implements Phone{
	public IPhone() {
		System.out.println("Android �⺻������ ȣ���!");
	}
	@Override
	public void power() {
		System.out.println("Iphone ����!");
	}

	@Override
	public void soundUp() {
		System.out.println("Iphone �Ҹ���!");
	}

	@Override
	public void soundDown() {
		System.out.println("Iphone �Ҹ��ٿ�!");
	}

}
