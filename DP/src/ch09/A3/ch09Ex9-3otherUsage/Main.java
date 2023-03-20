public class Main {
    public static void main(String[] args) {

        //기존의 기능 계층의 클래스들이 새로 만들어진 CharDisplayImpl을 이용함
        CountDisplay d1 = new CountDisplay(new CharDisplayImpl('<', '*', '>'));
        d1.multiDisplay(4);
		System.out.println( );

        RandomCountDisplay d2 = new RandomCountDisplay(new CharDisplayImpl('|', '#', '-'));
        d2.randomDisplay(5);
        System.out.println( );


        // 기존의 구현 계층의 클래스를 새로 만든 IncreaseDisplay가 이용한다.
        IncreaseDisplay d3 = new IncreaseDisplay(new StringDisplayImpl("abc"), 1);
		d3.increaseDisplay(4);
        System.out.println( );

        IncreaseDisplay d4 = new IncreaseDisplay(new FileDisplayImpl("star.txt"), 2);
        d4.increaseDisplay(3);
        System.out.println( );

    }
}
