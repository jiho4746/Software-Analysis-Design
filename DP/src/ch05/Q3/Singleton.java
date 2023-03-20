package ch05.Q3;

public class Singleton {
	private static Singleton singleton = null; //null(아무 객체가 없음)

	private Singleton() {
		System.out.println("인스턴스를 생성했습니다.");
	}

	public static Singleton getInstance() {
		// 객체가 생성되지 않았을 경우에만...
		if (singleton == null) {
			singleton = new Singleton();  // 새로 객체를 만든다.
		}
		return singleton; // 클라이언트가 첫번째 호출하면, singleton 객체 만들어서 리턴
		// 하지만!! 두번째 getInstance()를 하면, null이 아니기 때문에 미리 만들어져 있는 그대로 리턴
	}
}
