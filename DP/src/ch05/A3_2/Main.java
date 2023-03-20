package ch05.A3_2;

public class Main {
	public static void main(String[] args) {
		System.out.println("Start.");
		
		Singleton obj1 = Singleton.getInstance(); // 이 메소드 실행이 다 끝난 후에야
		Singleton obj2 = Singleton.getInstance(); // 이 메소드가 실행된다.
		
		if (obj1 == obj2) {
			System.out.println("obj1과 obj2는 같은 인스턴스입니다.");
		} else {
			System.out.println("obj1과obj2는 같은 인스턴스가 아닙니다.");
		}
		System.out.println("End.");
	}
}
