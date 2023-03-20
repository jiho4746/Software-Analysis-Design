package hw.ch17;

public class NamePrintObserver implements Observer{
	 public void update(NumberGenerator generator) {
	        System.out.print("Console ���:");
	        // ��������ڷκ��� ���ڸ� ��� �� ���ڸ�ŭ�� �ڱ� �̸��� ���ο� �� �ٿ� ����ؼ� ���
	        int count = generator.getNumber();
	        for (int i = 0; i < count; i++) {
	            System.out.print("����ȣ"); 
	        }
	        System.out.println("");
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	        }
	    }
}
