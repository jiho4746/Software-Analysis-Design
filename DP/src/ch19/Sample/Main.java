package ch19.Sample;

//public class Main extends Thread {
public class Main {
	public static void main(String[] args) {
		SafeFrame frame = new SafeFrame("State Sample");
		
		// 1초 간격으로 SafeFrame의 setClock( ) 메소드를 호출한다.
		while (true) {  // 무한루프
			for (int hour = 0; hour < 24; hour++) {
				frame.setClock(hour); // 금고의 시간을 설정한다.
				try {
					Thread.sleep(1000); // 1초간 쉰다.
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
