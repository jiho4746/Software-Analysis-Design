package ch23.Sample;

// 구문 트리의 각 부분(노드)를 대표하는 최상위의 클래스

public abstract class Node {
	// ‘구문 해석’이라는 처리를 실행하기 위한 메소드
	// 입력 인자 Context는,
	// 현재 구문 해석을 실행하고 있는 ‘상황’을 나타내는 클래스
	// 입력 문장 중에서 현재 어느 토큰까지 해석이 진행되었는지를 알고 있다.
	// 구문 해석 중에 에러가 발생하면, ParseException을 던진다.
	public abstract void parse(Context context) throws ParseException;
}
