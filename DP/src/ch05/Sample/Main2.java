package ch05.Sample;

public class Main2 {

	public static void main(String[] args) {
		// God 인스턴스를 얻어옴 (객체 생성 없이 클래스의 메소드 호출)
		God g1 = God.getInstance();
		God g2 = God.getInstance(); 
		//g1, g2 모두 God 인스턴스의 주소가 담김->똑같은 객체 참조
		
		// 둘이 같은지 비교
		if(g1 == g2) {
			System.out.println("둘이 같음");
		}
		else {
			System.out.println("둘이 다름");
		}
	}

}
