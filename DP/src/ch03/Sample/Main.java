package ch03.Sample;

public class Main {
	public static void main(String[] args) {
		
		// 'H'를 가진 CharDisplay의 인스턴스를 1개 만든다.
		AbstractDisplay d1 = new CharDisplay('H');
		
		// "Hello, world."를 가진 StringDisplay의 인스턴스를 1개 만든다.
		AbstractDisplay d2 = new StringDisplay("Hello, world.");
		
		// "안녕하세요"를 가진 StringDisplay의 인스턴스를 1개 만든다.
		AbstractDisplay d3 = new StringDisplay("안녕하세요.");

		// d1,d2,d3모두 같은 AbstractDisplay의 하위 클래스의 인스턴스이기 때문에
		// 상속한 display메소드를 호출할 수 있다.
		// 실제의 동작은 각 하위 클래스 CharDisplay나 StringDisplay에서 정한다.
		d1.display();
		d2.display();
		d3.display();
	}
}
