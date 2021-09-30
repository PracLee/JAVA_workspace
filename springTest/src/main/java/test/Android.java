package test;

public class Android implements Phone {
	private Watch watch;
	public Android() {
		System.out.println("Android �⺻������ ȣ���!");
	}
	public Android(Watch watch) {
		this.watch = watch;
		System.out.println("Android ������ ȣ���!");
	}
	@Override
	public void power() {
		System.out.println("Android ����!");
	}

	@Override
	public void soundUp() {
		watch.soundUp();
		// System.out.println("Android �Ҹ���!");
	}

	@Override
	public void soundDown() {
		watch.soundDown();
		// System.out.println("Android �Ҹ��ٿ�!");
	}

}
