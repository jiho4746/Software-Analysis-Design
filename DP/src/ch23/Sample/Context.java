package ch23.Sample;

import java.util.*;

// 구문 해석을 위해 필요한 여러가지 메소드를 제공한다.
// 미니 프로그램을 유지하면서, 
// 필요할 때마다 토큰으로 잘라서(lexical analysis) 
// 그 토큰을 반환하는 일을 함
// 토큰: 미니 프로그램을 구성하는 기본 단위 문자열
public class Context {
	// StringTokenizer: 주어진 문자열을 토큰으로 분할해 주는 클래스
	// 구분 문자(delimiter): 스페이스(‘ ‘), 탭(‘\t’), 뉴라인(‘\n’), 캐리지리턴(‘\r’), 폼피드(‘\f’)
	private StringTokenizer tokenizer;

	private String currentToken;

	public Context(String text) {
		// 주어진 문자열을 이용하여 StringTokenizer 객체를 생성한다.
		tokenizer = new StringTokenizer(text);
		nextToken(); // 첫 토큰을 currentToken 변수에 넣어둠
	}

	// 다음 토큰을 반환함(다음 토큰으로 나아감)
	public String nextToken() {
		if (tokenizer.hasMoreTokens()) {
			currentToken = tokenizer.nextToken();
		} else {
			currentToken = null;
		}
		return currentToken;
	}

	// 현재 토큰을 반환함
	public String currentToken() {
		return currentToken;
	}

	// 미니 프로그램의 현재 토큰과 입력인자 token이 같은지 비교해서, 
	// 같으면 다음 토큰으로 진행시키는 메소드
	public void skipToken(String token) throws ParseException {
		if (!token.equals(currentToken)) { // 현재 토큰과 입력인자 token을 비교해서,
			throw new ParseException("Warning: " + token + " is expected, but "
					+ currentToken + " is found."); // 다르면, 예외를 발생시킨다.
		}
		nextToken(); // 같으면 다음 토큰으로 진행시킨다.
	}

	// 현재 토큰 문자열을 정수로 바꾸어주는 메소드
	public int currentNumber() throws ParseException {
		int number = 0;
		try {
			number = Integer.parseInt(currentToken);
		} catch (NumberFormatException e) {
			throw new ParseException("Warning: " + e);
		}
		return number;
	}
}
