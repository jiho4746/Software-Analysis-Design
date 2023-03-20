package ch12.A1;

public class UpDownBorder extends Border {
    private char borderChar;                        // 장식이 되는 문자
    public UpDownBorder(Display display, char ch) {   // 생성자에서 Display와 장식문자를 지정
        super(display);
        this.borderChar = ch;
    }
    public int getColumns() {                       // 문자수는 내용물의 문자수와 동일
        return display.getColumns();
    }
    public int getRows() {                          // 줄수는 내용물의 상하에 장식문자분을 더한 것
        return 1 + display.getRows() + 1;
    }
    public String getRowText(int row) {             // 지정 줄의 내용
        if (row == 0 || row == getRows() - 1) { //맨 첫번째 줄, 마지막 줄인 경우
            return makeLine(borderChar, getColumns());
        } else {
            return display.getRowText(row - 1); //그 외의 줄인 경우
        }
    }
    private String makeLine(char ch, int count) { // 문자ch를count개 연속시킨 문자열을 작성
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
