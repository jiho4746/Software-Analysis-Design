package ch14.Sample;

// 홀수 번호의 트러블을 처리하는 클래스
public class OddSupport extends Support {
	public OddSupport(String name) { // 생성자
		super(name);
	}

	protected boolean resolve(Trouble trouble) { // 해결용 메소드
		if (trouble.getNumber() % 2 == 1) { // 2로 나눈 나머지가 1이면 , 홀수이다.
			return true;
		} else {
			return false;
		}
	}
}
