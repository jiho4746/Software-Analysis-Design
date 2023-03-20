package ch12.Sample;

import java.io.*;
	
public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, world."); //  ‘Hello, world.’를 장식하지 않고 표시한 것
        Display b2 = new SideBorder(b1, '#'); // b1에 대해 ‘#’ 문자로 좌우에 장식한 것
        Display b3 = new FullBorder(b2);  // b2에 대해 전체 장식을 한 것
        b1.show();
        b2.show();
        b3.show();
 
        //  ‘안녕하세요’에 여려 겹 장식을 한다.
        Display b4 = 
                    new SideBorder(
                        new FullBorder(
                            new FullBorder(
                                new SideBorder(
                                    new FullBorder(
                                        new StringDisplay("안녕하세요")
                                    ),
                                    '*'
                                )
                            )
                        ),
                        '/'
                    );
        b4.show();

		if(b1 instanceof StringDisplay) 
          System.out.println("b1 is instanceof StringDisplay");
		else if(b1 instanceof  SideBorder) 
		  System.out.println("b1 is instanceof SideBorder");

       if(b1 instanceof Display) 
          System.out.println("b1 is instanceof Display");
    }
}