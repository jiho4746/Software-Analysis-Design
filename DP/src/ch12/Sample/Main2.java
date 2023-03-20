package ch12.Sample;

public class Main2 {

	public static void main(String[] args) {
		Display s1 = new StringDisplay("��������"); //�θ�Ÿ������ ����
		System.out.println(s1.getRowText(0));
		
		//����� �����
		Display s2 = new SideBorder(s1, '$');
		s2.show(); //$��������$
		
		Display s3 = new SideBorder(s2, '&');
		s3.show(); //&$��������$&

		Display s4 = new FullBorder(s1);
		s4.show();
		
		Display s5 = new FullBorder(s4);
		s5.show();
		
		Display s6 = new FullBorder(new SideBorder(new StringDisplay("xxx"), '@'));
		s6.show();
	}

}
