package hw.ch17;

import java.util.Random;

public class PrimeNumberGenerator extends NumberGenerator{
    private Random random = new Random();   // 난수발생기
    private int number;                     // 생성된 수
    public int getNumber() {                // 수를 취득한다.
        return number;
    }
    public void execute() {
        for (int i = 0; i < 100; i++) { //100개를 생성
        	number = random.nextInt(100) + 1; //1~100사이의 임의의 숫자
        	if(isPrimeNumber(number) == true) { //소수인지 검사해서 true이면 등록된 관찰자에게 통지
        		notifyObservers(); 
        	}
    		try {
    			Thread.sleep(1500);
    		} catch (InterruptedException e) {
    		}
        }
    }
    //생성된 숫자가 소수인지 검사해서 true이면 등록된 관찰자에게 통지한다
	private boolean isPrimeNumber(int number) {
		if(number == 1) return false;
		for(int i=2; i<Math.sqrt(number); i++) {
			if(number % i == 0 ) return false; //소수가 아니라면 false 리턴
		}
		return true; // 소수라면 true 리턴
	}
}
