package hw.ch04;

import hw.ch04.tv.*;

public class Main {
    public static void main(String[] args) {
    	System.out.println("��ǻ�Ͱ��а� 20200769 ����ȣ");
    	System.out.println("----------------------------------");
    	
		// ������ �����.
        Factory factory = new TVFactory();
        
		// ������ �̿��ؼ� ��ǰ(TV_ParkJiHo�� �����Ѵ�) 
		Product tv1 = factory.create("20200769");
        Product tv2 = factory.create("111");
        Product tv3 = factory.create("222");
        Product tv4 = factory.create("333");

		// ����� ��ǰ�� ����Ѵ�.
        tv1.use();
        tv2.use();
        tv3.use();
        tv4.use();
        
        System.out.println();
        
        //��� TV�� �� ��ȣ�� ���
        ((TVFactory)factory).printAllModelNumbers();
    }
}
