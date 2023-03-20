package ch04.A2;

import java.util.Hashtable;
import java.util.Iterator;

import ch04.A2.framework.*;
import ch04.A2.idcard.*;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("홍길동"); //("홍길동", 100)
        Product card2 = factory.create("이순신"); //("이순신", 101)
        Product card3 = factory.create("강감찬"); //("강감찬", 101)
        card1.use();
        card2.use();
        card3.use();
        
        //[value값만 하나씩 찍어보려고 함]
        Hashtable h = ((IDCardFactory)factory).getDatabase();
        
        Iterator i  = h.values().iterator(); //values만 가져오고 하나씩 돌아다님
        while(i.hasNext()) {
        	System.out.println(i.next());
        }
    }
}
