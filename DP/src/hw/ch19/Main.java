package hw.ch19;

public class Main extends Thread {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("20200769 ����ȣ");
        while (true) {
        	// 15:00~24:00�� �ݺ��ǵ��� ��
            for (int hour = 15; hour <= 24; hour++) { // ���� �ð��� 15:00���� �ٲ۴�
                frame.setClock(hour);   // �ð��� ����
                try {
                    Thread.sleep(3000); // 3�ʴ� 1�ð��� �帧
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
