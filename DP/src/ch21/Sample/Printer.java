package ch21.Sample;


// ‘본인’을 나타내는 클래스
public class Printer implements Printable {
	private String name;

	public Printer() {
		heavyJob("Printer의 인스턴스를 생성중"); //본인을 생성할 때는 시간이 오래 걸림
	}

	public Printer(String name) { // 생성자
		this.name = name;
		heavyJob("Printer의 인스턴스(" + name + ")를 생성중");
	}

	public void setPrinterName(String name) { // 이름의 설정
		this.name = name;
	}

	public String getPrinterName() { // 이름의 취득
		return name;
	}

	// 프린터 이름과 문자열을 화면에 출력함
	public void print(String string) {
		System.out.println("=== " + name + " ===");
		System.out.println(string);
	}

	// 무거운 작업을 나타냄
	// 5초가 걸리는 상대적으로 오래 걸리는 일
	private void heavyJob(String msg) { 
		System.out.print(msg);
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.print(".");
		}
		System.out.println("완료");
	}

	@Override
	public void print2(String string) {
		System.out.println("본인-print2(): "+string);
	}

	@Override
	public void print3(String string) {
		System.out.println("본인-print3(): "+string);
	}
}
