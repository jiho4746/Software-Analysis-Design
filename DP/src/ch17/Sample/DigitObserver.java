package ch17.Sample;

// Observer 인터페이스를 구현한 구체적인 관찰자
public class DigitObserver implements Observer {
	public void update(NumberGenerator generator) { // 부모타입으로 선언
		System.out.println("DigitObserver:" + generator.getNumber()); // 관찰한 수를 ‘숫자’로 표시함
		try {
			// 출력한 후, 표시된 모습을 잘 알 수 있도록 
			// Thread.sleep( )을 이용하여 스피드를 늦춘다.
			Thread.sleep(100); // (100/1000 = 0.1 초) 동안 CPU를 반환하고 쉬겠다는 뜻
		} catch (InterruptedException e) {
		}
	}
}
