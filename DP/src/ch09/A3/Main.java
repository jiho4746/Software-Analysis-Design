package ch09.A3;

public class Main {
    public static void main(String[] args) {
        IncreaseDisplay d1 = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'), 1);
        IncreaseDisplay d2 = new IncreaseDisplay(new CharDisplayImpl('|', '#', '-'), 2);
        //추가 코드
        IncreaseDisplay d3 = new IncreaseDisplay(new CharDisplayImpl('^', '&', '^'), 3);
        IncreaseDisplay d4 = new IncreaseDisplay(new StringDisplayImpl("박지호"), 3);
        
        d1.increaseDisplay(4);
        d2.increaseDisplay(6);
        d3.increaseDisplay(10);
        d4.increaseDisplay(5);
    }
}
