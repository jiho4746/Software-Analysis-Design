package ch05.Sample;

//인스턴스가 1개만 생성되도록 하려고 함
public class God {
	
	//(3) 미리 God 인스턴스를 생성해 놓음
	//static 함수는 static 변수만을 이용
	private  static God g = new God(); //클래스 로드 시 객체가 미리 만들어짐
	
	//(1) 생성자를 private으로 함 (public이면 계속 생성할 수 있음)
	private God() {
		System.out.println("God이 생성됨");
	}
	
	//(2) God 인스턴스를 얻어가는 메소드를 만듦
	public static God getInstance() { //static -> 클래스에 속하는 메소드
		return g;
	}
}
