package hw.ch05;

import hw.ch05.idcard.IDCardFactoryParkJiHo1;

//속성에서 미리 생성하는 방식
public class Main1 {
    public static void main(String[] args) {
    	System.out.println("컴퓨터공학과 20200769 박지호");
    	System.out.println("----------------------------------");
    	System.out.println("Main1");
    	
		// 객체를 두 번 얻어온다.
        IDCardFactoryParkJiHo1 factory1 = IDCardFactoryParkJiHo1.getInstance();
        IDCardFactoryParkJiHo1 factory2 = IDCardFactoryParkJiHo1.getInstance();

		// 객체의 주소가 같은지 비교한다.
        if (factory1 == factory2) {
            System.out.println("factory1과 factory2는 같은 인스턴스입니다.");
        } else {
            System.out.println("factory1과 factory2는 같은 인스턴스입니다.");
        }
    }
}
