package hw.ch03;

public class Main {
	public static void main(String[] args) {
		System.out.println("��ǻ�Ͱ��а� 20200769 ����ȣ");
    	System.out.println("----------------------------------");
    	System.out.println();
    	
		AbstractDisplay d1 = new ParkJiHoDisplay("����ȣ", "20200769", 3);		
		d1.display(10);

	}
}
