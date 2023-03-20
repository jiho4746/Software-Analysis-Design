package hw.ch12;

public class MultiSideBorder extends Border{
	private char borderChar;
	private int borderNum;
	
	public MultiSideBorder(Display display, char ch, int num) {
        super(display);
        this.borderChar = ch;
        this.borderNum = num;
    }
	public String starNum() {
		String star = "*";
		star = star.repeat(borderNum); //문자열 반복
		return star;
	}
    public int getColumns() {                   // 문자수는 내용물의 양쪽에 좌우의 장식 문자분을 더한 것
        return 1 + display.getColumns() + 1;
    }
    public int getRows() {                      // 줄수는 내용물의 줄수에 상하의 장식문자분을 더한 것
        return 1 + display.getRows() + 1;
    }
    public String getRowText(int row) {         // 지정한 줄의 내용
        if (row == 0) {                                                 // 장식의 상단
            return starNum() + makeLine(borderChar, display.getColumns()) + starNum();
        } else if (row == display.getRows() + 1) {                      // 장식의 하단
            return starNum() + makeLine(borderChar, display.getColumns()) + starNum();
        } else {                                                        // 그 밖에
            return starNum() + display.getRowText(row - 1) + starNum();
        }
    }
    
   
    private String makeLine(char ch, int count) {         // 문자ch를count개 연속 시킨 문자열을 만든다.
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
