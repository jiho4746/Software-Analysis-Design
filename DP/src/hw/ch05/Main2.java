package hw.ch05;

import hw.ch05.idcard.IDCardFactoryParkJiHo2;

// Thread Ŭ������ ��ӹ޾Ƽ�, Main Ŭ���� �ڽ��� �����尡 �ȴ�.
public class Main2 extends Thread {
	public static void main(String[] args) {
		System.out.println("��ǻ�Ͱ��а� 20200769 ����ȣ");
    	System.out.println("----------------------------------");
    	System.out.println("Main2");
    	
        // ������ 3���� ������ �� �����Ų��.
		new Main2("�ֽ���").start(); // �����忡 start()�� �ϸ�, run( ) �� �ڵ����� ����ȴ�.
		new Main2("����ȣ").start();
		new Main2("ȫ�浿").start();
	}

	public void run() {
		IDCardFactoryParkJiHo2 obj = IDCardFactoryParkJiHo2.getInstance();
		System.out.println(getName() + ": obj = " + obj);
	}

	public Main2(String name) {
		super(name);
	}
}
