package ch14.Sample;

public class Main {
	public static void main(String[] args) {
		// 여섯 명의 트러블 해결자 생성 (부모타입으로 선언)
		Support alice = new NoSupport("Alice");
		Support bob = new LimitSupport("Bob", 100);
		Support charlie = new SpecialSupport("Charlie", 429);
		Support diana = new LimitSupport("Diana", 200);
		Support elmo = new OddSupport("Elmo");
		Support fred = new LimitSupport("Fred", 300);
		Support csh = new OddSupport("csh");
		
		// Chain of Responsibility 형성 (사슬처럼 만들기)
		// 주의할 점: alice.setNext(bob)의 반환값은 bob 객체(에 대한 참조)이다.
		alice.setNext(bob).setNext(csh).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
		
		// 다양한 트러블 발생해서 첫번째 해결자인 alice 에게 해결을 요청한다.
		for (int i = 0; i < 500; i += 33) {
			alice.support(new Trouble(i));
		}
	}
}
