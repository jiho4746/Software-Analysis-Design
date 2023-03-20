package ch05.Sample;

public class Singleton {
	// Singleton 객체 하나를 생성해서 가리키는 정적 필드
	// 클래스가 메모리에 로드될 때 한번 실행됨
	private static Singleton singleton = new Singleton();

	// 생성자
	private Singleton() {
		System.out.println("인스턴스를 생성했습니다.");
	}

	// singleton 정적 필드가 가리키는 Singleton 객체를 반환함
	public static Singleton getInstance() {
		System.out.println("인스턴스를 반환합니다.");
		return singleton;
	}
}
