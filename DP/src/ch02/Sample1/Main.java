package ch02.Sample1;

public class Main {
	public static void main(String[] args) {
		// p는 Print 인터페이스 형으로 선언되었고,
		// 실제로는 PrintBanner 객체를 생성하여 가리킨다.
		// Print가 PrintBanner의 부모이므로 가능하다.
		Print p = new PrintBanner("Hello");

		// 실제 일을 수행하는 Banner 클래스의 메소드는,
		// Main 클래스에서는 완전히 은폐되어 있다.
		p.printWeak();
		p.printStrong();
	}
}
