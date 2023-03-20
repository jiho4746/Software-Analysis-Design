package ch04.Sample;

import ch04.Sample.framework.*;
import ch04.Sample.idcard.*;

public class Main {
    public static void main(String[] args) {

      // IDCard( ) 생성자가 public이 아니라, 아래 문장은 오류가 발생한다.	
      //IDCard card1 = new IDCard("홍길동");

		// 공장을 세운다.
        Factory factory = new IDCardFactory();
        
		// 공장을 이용해서 제품(IDCard를 생산한다) 
		Product card1 = factory.create("홍길동");
        Product card2 = factory.create("이순신");
        Product card3 = factory.create("강감찬");

		// 생산된 제품을 사용한다.
        card1.use();
        card2.use();
        card3.use();
    }
}
