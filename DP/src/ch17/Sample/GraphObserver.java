package ch17.Sample;

// Observer 인터페이스를 구현한 구체적인 관찰자
public class GraphObserver implements Observer {
	// 관찰한 수를 ‘간단한 그래프’로 표시함
	public void update(NumberGenerator generator) {
		System.out.print("GraphObserver:");
		int count = generator.getNumber();
		// count 만큼 별표를 출력한다.
		for (int i = 0; i < count; i++) {
			System.out.print("*");
		}
		System.out.println("");
		try {
			Thread.sleep(100); // (100/1000 = 0.1 초) 동안 CPU를 반환하고 쉬겠다는 뜻
		} catch (InterruptedException e) {
		}
	}
}
