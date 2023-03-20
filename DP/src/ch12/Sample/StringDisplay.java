package ch12.Sample;

// 여러 케이크의 중심에 있는 스펀지 케이크에 해당하는 클래스
public class StringDisplay extends Display {
	private String string; // 표시할 문자열을 저장함

	public StringDisplay(String string) { // 인수로 표시문자열을 지정
		this.string = string;
	}

	public int getColumns() { // 문자수
		return string.getBytes().length; // 문자열이 차지하는 바이트 수를 반환함
	}

	public int getRows() { // 줄수는 1
		return 1;
	}

	// 입력 매개 변수 row가 0일 때만 string 필드를 반환한다.
	public String getRowText(int row) {
		if (row == 0) {
			return string;
		} else {
			return null;
		}
	}
}
