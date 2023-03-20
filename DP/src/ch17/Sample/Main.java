package ch17.Sample;

public class Main {
	public static void main(String[] args) {
		// RandomNumberGenerator 인스턴스 1 개 생성함
		NumberGenerator generator = new RandomNumberGenerator();
		
		// 관찰자 2개 생성함
		Observer observer1 = new DigitObserver();
		Observer observer2 = new GraphObserver();
		
		// RandomNumberGenerator에 관찰자 2개를 등록함
		generator.addObserver(observer1);
		generator.addObserver(observer2);
		
		// RandomNumberGenerator의 execute( )를 이용해서 수를 생성한다
		generator.execute();
		// 난수가 발생될 때마다, 관찰자들은 각자의 방식대로 수를 ‘표시’한다.
	}
}
