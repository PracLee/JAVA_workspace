package test;

public class AppleWatch implements Watch{
	public AppleWatch() {
		System.out.println("���ÿ�ġ �⺻������ ȣ���!");
	}
	public void soundUp() {
		System.out.println("���� ��ġ�� �Ҹ���!");
	}

	@Override
	public void soundDown() {
		System.out.println("���� ��ġ�� �Ҹ��ٿ�!");
	}

}
