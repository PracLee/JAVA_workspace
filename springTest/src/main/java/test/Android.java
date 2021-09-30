package test;

public class Android implements Phone {
	private Watch watch;
	public Android() {
		System.out.println("Android 기본생성자 호출됨!");
	}
	public Android(Watch watch) {
		this.watch = watch;
		System.out.println("Android 생성자 호출됨!");
	}
	@Override
	public void power() {
		System.out.println("Android 전원!");
	}

	@Override
	public void soundUp() {
		watch.soundUp();
		// System.out.println("Android 소리업!");
	}

	@Override
	public void soundDown() {
		watch.soundDown();
		// System.out.println("Android 소리다운!");
	}

}
