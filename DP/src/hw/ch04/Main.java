package hw.ch04;

import hw.ch04.tv.*;

public class Main {
    public static void main(String[] args) {
    	System.out.println("컴퓨터공학과 20200769 박지호");
    	System.out.println("----------------------------------");
    	
		// 공장을 세운다.
        Factory factory = new TVFactory();
        
		// 공장을 이용해서 제품(TV_ParkJiHo를 생산한다) 
		Product tv1 = factory.create("20200769");
        Product tv2 = factory.create("111");
        Product tv3 = factory.create("222");
        Product tv4 = factory.create("333");

		// 생산된 제품을 사용한다.
        tv1.use();
        tv2.use();
        tv3.use();
        tv4.use();
        
        System.out.println();
        
        //모든 TV의 모델 번호를 출력
        ((TVFactory)factory).printAllModelNumbers();
    }
}
