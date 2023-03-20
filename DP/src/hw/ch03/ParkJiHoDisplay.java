package hw.ch03;

//ParkJiHoDisplay는 AbstractDisplay의 하위 클래스
public class ParkJiHoDisplay extends AbstractDisplay{
	// 표시해야 할 문자를 저장한다.
		private String na;
		private String st;
		private int gr;

		public ParkJiHoDisplay(String name, String studentId, int grade) {
			this.na = name; // 필드(속성)에 기억해 둔다.
			this.st = studentId;
			this.gr = grade;
		}

		// 상위 클래스에서는 추상메소드였다. 여기서 오버라이드 해서 구현.
		public void open() {
			System.out.println("==========================");
			System.out.println("덕성여대 컴퓨터공학과");
		}

		// print메소드로 여기서 구현한다. 이것이 display에서 반복해서 호출된다.
		public void print() {
			System.out.println("학번 "+st+" / "+gr+"학년"+" / "+na);//자기 이름과 학번 출력;
		}

		// close메소드도 여기서 구현
		public void close() {
			System.out.println("템플릿 메소드 패턴 숙제입니다");
			System.out.println("==========================");
		}
}
