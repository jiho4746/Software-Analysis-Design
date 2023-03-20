package ch04.A2;

import java.util.Hashtable;
import java.util.Iterator;

import ch04.A2.framework.*;
import ch04.A2.idcard.*;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("ȫ�浿"); //("ȫ�浿", 100)
        Product card2 = factory.create("�̼���"); //("�̼���", 101)
        Product card3 = factory.create("������"); //("������", 101)
        card1.use();
        card2.use();
        card3.use();
        
        //[value���� �ϳ��� ������ ��]
        Hashtable h = ((IDCardFactory)factory).getDatabase();
        
        Iterator i  = h.values().iterator(); //values�� �������� �ϳ��� ���ƴٴ�
        while(i.hasNext()) {
        	System.out.println(i.next());
        }
    }
}
