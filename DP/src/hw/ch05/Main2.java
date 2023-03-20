package hw.ch05;

import hw.ch05.idcard.IDCardFactoryParkJiHo2;

// Thread 클래스를 상속받아서, Main 클래스 자신이 스레드가 된다.
public class Main2 extends Thread {
	public static void main(String[] args) {
		System.out.println("컴퓨터공학과 20200769 박지호");
    	System.out.println("----------------------------------");
    	System.out.println("Main2");
    	
        // 스레드 3개를 생성한 후 실행시킨다.
		new Main2("최승훈").start(); // 스레드에 start()를 하면, run( ) 이 자동으로 실행된다.
		new Main2("박지호").start();
		new Main2("홍길동").start();
	}

	public void run() {
		IDCardFactoryParkJiHo2 obj = IDCardFactoryParkJiHo2.getInstance();
		System.out.println(getName() + ": obj = " + obj);
	}

	public Main2(String name) {
		super(name);
	}
}
