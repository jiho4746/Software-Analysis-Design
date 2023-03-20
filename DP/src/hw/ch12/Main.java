package hw.ch12;

public class Main {
    public static void main(String[] args) {
    	System.out.println("컴퓨터공학과 20200769 박지호");
    	System.out.println();
    	
        MultiStringDisplay md = new MultiStringDisplay();
        md.add("학번: 20200769");
        md.add("이름: 박지호");
        md.add("핸드폰 번호 : 010-1234-5678");


        Display d1 = new SideBorder(md, '%');
        Display d2 = new FullBorder(d1);
        Display d3 = new MultiSideBorder(d2, '=', 3);
        d3.show();
    }
}
