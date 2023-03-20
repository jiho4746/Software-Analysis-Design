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
		star = star.repeat(borderNum); //���ڿ� �ݺ�
		return star;
	}
    public int getColumns() {                   // ���ڼ��� ���빰�� ���ʿ� �¿��� ��� ���ں��� ���� ��
        return 1 + display.getColumns() + 1;
    }
    public int getRows() {                      // �ټ��� ���빰�� �ټ��� ������ ��Ĺ��ں��� ���� ��
        return 1 + display.getRows() + 1;
    }
    public String getRowText(int row) {         // ������ ���� ����
        if (row == 0) {                                                 // ����� ���
            return starNum() + makeLine(borderChar, display.getColumns()) + starNum();
        } else if (row == display.getRows() + 1) {                      // ����� �ϴ�
            return starNum() + makeLine(borderChar, display.getColumns()) + starNum();
        } else {                                                        // �� �ۿ�
            return starNum() + display.getRowText(row - 1) + starNum();
        }
    }
    
   
    private String makeLine(char ch, int count) {         // ����ch��count�� ���� ��Ų ���ڿ��� �����.
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
