package ch21.Sample;

public class Main2 {

	public static void main(String[] args) {
		// 수업 떄 만든 Main()
		
		/*
		//본인 (시간이 오래 걸림)
		Printable p1 = new Printer("p1"); //5초 정도 걸림
		p1.print("박지호"); //p1이라는 프린터가 "박지호" 출력
		*/
		
		//대리인을 만들어서 일을 빨리 처리
		//실제 일을 하는 ‘본인’ 객체가 생성되지 않았으면 생성하므로 오래 걸림
		Printable p2 = new PrinterProxy("p2"); 
		p2.print2("박지호1"); //대리인이 일을 함
		p2.print("박지호2"); //본인 생성 -> 본인이 일을 함
		p2.print3("a"); //짧게 주면 대리인이 일을 함
		p2.print3("aaaaa"); //위에서 본인이 이미 생성됨 -> 길게 주면 본인이 일을 함
	}
	public static void method(Printable p) { //본인&대리인 둘다 가능(부모타입으로 선언)
		p.print("abc");
	}
}
