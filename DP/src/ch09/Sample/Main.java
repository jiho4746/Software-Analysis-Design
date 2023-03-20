package ch09.Sample;

import ch03.Sample.StringDisplay;

public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, Korea."));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));
        d1.display();
        d2.display();
		((CountDisplay)d2).multiDisplay(3);
        d3.display();
        d3.multiDisplay(5);
        
        // 추가 코드
        Display d4 = new Display(new StringDisplayImpl("박지호"));
        d4.display();
        
        Display d5 = new Display(new StringDisplayImpl("박지호2"));
     // d5의 타입은 Display -> Display에 multiDisplay 메소드가 없음 -> 타입캐스팅
        ((CountDisplay)d5).multiDisplay(5); 
    }
}
