package hw.ch19;

public class Main extends Thread {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("20200769 박지호");
        while (true) {
        	// 15:00~24:00가 반복되도록 함
            for (int hour = 15; hour <= 24; hour++) { // 최초 시간을 15:00으로 바꾼다
                frame.setClock(hour);   // 시각의 설정
                try {
                    Thread.sleep(3000); // 3초당 1시간이 흐름
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
