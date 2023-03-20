package hw.ch17;

import java.util.Random;

public class PrimeNumberGenerator extends NumberGenerator{
    private Random random = new Random();   // �����߻���
    private int number;                     // ������ ��
    public int getNumber() {                // ���� ����Ѵ�.
        return number;
    }
    public void execute() {
        for (int i = 0; i < 100; i++) { //100���� ����
        	number = random.nextInt(100) + 1; //1~100������ ������ ����
        	if(isPrimeNumber(number) == true) { //�Ҽ����� �˻��ؼ� true�̸� ��ϵ� �����ڿ��� ����
        		notifyObservers(); 
        	}
    		try {
    			Thread.sleep(1500);
    		} catch (InterruptedException e) {
    		}
        }
    }
    //������ ���ڰ� �Ҽ����� �˻��ؼ� true�̸� ��ϵ� �����ڿ��� �����Ѵ�
	private boolean isPrimeNumber(int number) {
		if(number == 1) return false;
		for(int i=2; i<Math.sqrt(number); i++) {
			if(number % i == 0 ) return false; //�Ҽ��� �ƴ϶�� false ����
		}
		return true; // �Ҽ���� true ����
	}
}
