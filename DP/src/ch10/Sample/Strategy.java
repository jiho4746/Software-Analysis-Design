package ch10.Sample;

public interface Strategy {
	//다음에 내밀 손을 얻기 위해 호출하는 메소드
	// 이 메소드가 호출되면, 
	// Strategy 인터페이스를 구현한 클래스가 지혜를 모아 ‘다음 손’을 결정함
	public abstract Hand nextHand(); // 다음에 내밀 손을 알려준다.

	// 다음 승부에 사용될 전략을 준비시키는 메소드
	// 이긴 경우에는 Player가 study(true)를 호출하고, 
	// 진 경우에는 Player가 study(false)를 호출한다.
	public abstract void study(boolean win);
}
