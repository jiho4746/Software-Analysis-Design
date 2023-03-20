package ch05.A1;

public class TicketMaker {
	private int ticket = 1000;

	private static TicketMaker singleton = new TicketMaker();

	private TicketMaker() {
	}

	public static TicketMaker getInstance() {
		return singleton;
	}

	// 한 스레드가 이 메소드를 호출해서 실행하는 동안
	// 다른 스레드가 이 메소드를 호출하는 경우,
	// 두 스레드가 모두 같은 값을 반환받는 경우가 발생할 수 있다.
	// 왜? 
	// 다음과 같은 경우가 발생할 수 있다.
	// ticket의 현재 값이 10이라고 하자.
	// 스레드 A가 이 메소드를 호출 시 실행 시  ticket 값을 꺼내와서 1 올리기직전,
	// CPU가 다른 스레드(B)에게 할당되어 이 메소드가 실행된다고 하자.
	// 스레드 B로부터 호출된 메소드 실행이 먼저 끝난다면,
	// 스레드 B는 11을 반환값으로 가져간다.
	// 그 후 스레드 A가 나머지 부분을 실행하면 똑같이 11을 반환값으로 가져간다.
	public synchronized int getNextTicketNumber() {
		return ticket++; // 3가지 job으로 구성됨: ticket 값을 꺼내오고, 1 더하고, 다시 ticket 에 쓴다.
	}
}
