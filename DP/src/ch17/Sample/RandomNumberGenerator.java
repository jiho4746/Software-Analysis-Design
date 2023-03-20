package ch17.Sample;

import java.util.Random;

// NumberGenerator의 하위 클래스
public class RandomNumberGenerator extends NumberGenerator {
	// java.util.Random 클래스 이용
	private Random random = new Random(); // 난수발생기

	private int number; // 생성된 난수를 저장하는 변수

	public int getNumber() { // 수를 취득한다.
		return number; // number 필드의 값을 반환함
	}

	// 0~49 까지의 난수 20개를 생성하고, 
	// 그 때마다 notifyObservers를 호출하여, 
	// 관찰자들에게 통지한다.
	public void execute() {
		for (int i = 0; i < 20; i++) {
			number = random.nextInt(50);
			notifyObservers(); // 관찰자에게 통지하라고 요청한다.
		}
	}
}
