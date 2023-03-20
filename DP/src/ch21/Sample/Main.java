package ch21.Sample;

// PrinterProxy를 경유해서, Printer를 이용하는 클래스
public class Main {
	public static void main(String[] args) {
		// 먼저, PrinterProxy 생성 한다. (대리인 생성)
		Printable p = new PrinterProxy("Alice");
		System.out.println("현재의 이름은" + p.getPrinterName() + "입니다.");
		
		// '본인'의 이름을 Bob으로 설정한다.
		p.setPrinterName("Bob"); //대리인이 일을 함
		System.out.println("현재의 이름은" + p.getPrinterName() + "입니다."); //대리인이 일을 함

		// 이전까지는 본인인 Printer객체는 생성되지 않았다.
		// 즉, 대리인인 PrinterProxy 객체가 일을 한다.

		p.print("Hello, world."); // 이 문장이 실행될 때, 비로소 본인인 Printer 객체가 만들어진다.
		                                       // 필요할 때 비로소 생성된다.

	}
}
