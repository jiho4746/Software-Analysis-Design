package ch05.A3_2;

public class Singleton {
	private static Singleton singleton = null;

	private Singleton() {
		System.out.println("인스턴스를 생성했습니다.");
		slowdown(); // 생성 시 1초간 쉰다.
	}
	
	public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

	private void slowdown() {
		try {
			Thread.sleep(20000); // 이 메소드를 호출한 스레드는 1000 밀리초, 즉 1초가 CPU를 내놓고
									// 쉰다.
		} catch (InterruptedException e) {
		}
	}
}
