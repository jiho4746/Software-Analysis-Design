package hw.ch05;

import hw.ch05.idcard.IDCardFactoryParkJiHo1;

//�Ӽ����� �̸� �����ϴ� ���
public class Main1 {
    public static void main(String[] args) {
    	System.out.println("��ǻ�Ͱ��а� 20200769 ����ȣ");
    	System.out.println("----------------------------------");
    	System.out.println("Main1");
    	
		// ��ü�� �� �� ���´�.
        IDCardFactoryParkJiHo1 factory1 = IDCardFactoryParkJiHo1.getInstance();
        IDCardFactoryParkJiHo1 factory2 = IDCardFactoryParkJiHo1.getInstance();

		// ��ü�� �ּҰ� ������ ���Ѵ�.
        if (factory1 == factory2) {
            System.out.println("factory1�� factory2�� ���� �ν��Ͻ��Դϴ�.");
        } else {
            System.out.println("factory1�� factory2�� ���� �ν��Ͻ��Դϴ�.");
        }
    }
}
