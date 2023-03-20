package ch12.Sample;

// 상하좌우에 장식을 다는 클래스
// SideBorder와 달리, 장식할 문자가 미리 고정되어 있다.
public class FullBorder extends Border {
    public FullBorder(Display display) {
        super(display);
    }
    // 문자수는 내용물의 양쪽에 좌우의 장식 문자분을 더한 것
    public int getColumns() {                   
        return 1 + display.getColumns() + 1;
    }
    //  줄수는 내용물의 줄수에 상하의 장식문자분을 더한 것
    public int getRows() {                     
        return 1 + display.getRows() + 1;
    }
    // 지정한 줄의 내용을 반환함
    public String getRowText(int row) { 
        if (row == 0) {                                                 // 장식의 상단인 경우
            return "+" + makeLine('-', display.getColumns()) + "+"; // "+---------------------+" 를 만든다.
        } else if (row == display.getRows() + 1) {                      // 장식의 하단인 경우
            return "+" + makeLine('-', display.getColumns()) + "+";  // "+---------------------+" 를 만든다.
        } else {                                                        // 그 밖의 경우
            return "|" + display.getRowText(row - 1) + "|"; //0부터 시작하기 때문에 -1
        }
    }
    
    // ch를 count 갯수 만큼 연속해서 문자열로 만드는 메소드
    private String makeLine(char ch, int count) {  
        StringBuffer buf = new StringBuffer(); //내용이 계속 변경되는 경우에는 StringBuffer() 사용
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
