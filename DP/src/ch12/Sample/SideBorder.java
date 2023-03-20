package ch12.Sample;

// 구체적인 장식의 일종
// 문자열 좌우에 정해진 문자(BorderChar)로 장식한다.
public class SideBorder extends Border {
	private char borderChar; // 장식이 되는 문자

	// 생성자에서, 내용물(display)과 장식 문자(ch)가 지정됨
	public SideBorder(Display display, char ch) { 
		super(display);
		this.borderChar = ch;
	}

	// 내용물의 문자 수에 2(내용물의 양쪽에 장식 문자분)를 더한다.
	public int getColumns() {
		return 1 + display.getColumns() + 1;
	}

	// 줄수는 내용물의 줄수와 같으므로, 내용물의 getRows( )를 호출한다.
	public int getRows() { 
		return display.getRows();
	}

	// 지정한 줄의 내용물의 Text 양쪽에 장식 문자를 연결하여 반환한다.
	public String getRowText(int row) { 
		return borderChar + display.getRowText(row) + borderChar;
	}
}
