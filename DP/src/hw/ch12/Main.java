package hw.ch12;

public class Main {
    public static void main(String[] args) {
    	System.out.println("��ǻ�Ͱ��а� 20200769 ����ȣ");
    	System.out.println();
    	
        MultiStringDisplay md = new MultiStringDisplay();
        md.add("�й�: 20200769");
        md.add("�̸�: ����ȣ");
        md.add("�ڵ��� ��ȣ : 010-1234-5678");


        Display d1 = new SideBorder(md, '%');
        Display d2 = new FullBorder(d1);
        Display d3 = new MultiSideBorder(d2, '=', 3);
        d3.show();
    }
}
