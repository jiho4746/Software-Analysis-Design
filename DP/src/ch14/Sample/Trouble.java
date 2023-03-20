package ch14.Sample;

public class Trouble {
	private int number; // 트러블 번호를 유지함

	// 트러블의 생성자
	public Trouble(int number) {
		this.number = number;
	}

	// 트러블 번호를 반환하는 메소드
	public int getNumber() {
		return number;
	}

	public String toString() { // 트러블의 문자열 표현
		return "[Trouble " + number + "]";
	}
}
