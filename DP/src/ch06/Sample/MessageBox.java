package ch06.Sample;

import ch06.Sample.framework.*;

public class MessageBox implements Product {
    private char decochar;
    public MessageBox(char decochar) {
        this.decochar = decochar;
    }
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length + 4; i++) { //줄을 맞춰서 출력하기 위해서 +4
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar + " "  + s + " " + decochar);
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
    }
    public Product createClone() {
	        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) { //Clone 메소드가 제공되지 않았을 때 (예외)
            e.printStackTrace();
        }
        return p;
	}
}
