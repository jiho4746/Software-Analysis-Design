package ch05.A3_1;

// Thread 클래스를 상속받아서, Main 클래스 자신이 스레드가 된다.
public class Main extends Thread {
	public static void main(String[] args) {
		System.out.println("Start.");
        // 스레드 3개를 생성한 후 실행시킨다.
		new Main("A").start(); // 스레드에 start()를 하면, run( ) 이 자동으로 실행된다.
		new Main("B").start();
		new Main("C").start();
		System.out.println("End.");
	}

	public void run() {
		Singleton obj = Singleton.getInstance();
		System.out.println(getName() + ": obj = " + obj);
	}

	public Main(String name) {
		super(name);
	}
}
