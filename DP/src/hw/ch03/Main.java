package hw.ch03;

public class Main {
	public static void main(String[] args) {
		System.out.println("컴퓨터공학과 20200769 박지호");
    	System.out.println("----------------------------------");
    	System.out.println();
    	
		AbstractDisplay d1 = new ParkJiHoDisplay("박지호", "20200769", 3);		
		d1.display(10);

	}
}
