package ch14.Sample;

// 트러블을 해결할 연쇄를 만들기 위한 추상 클래스
public abstract class Support {
	private String name; // 트러블 해결자의 이름

	// 자기 다음 번에 트러블을 해결할 객체(떠넘기기를 할 곳)를 가리킨다.
	private Support next; //부모타입->뭐든지 가르킬 수 있음

	public Support(String name) { // 트러블 해결자의 생성
		this.name = name;
	}

	public Support setNext(Support next) { // 떠넘길 곳을 설정
		this.next = next;
		return next; // 자기 다음 해결자를 반환한다.
	}

	// 템플릿 메소드 <- resolve( )는 추상 메소드이다.
	public final void support(Trouble trouble) { 
	    if (resolve(trouble)) { // resolve( ) 메소드를 호출해서 성공하면...
			done(trouble); // 해결되었다고 출력한다.
		} else if (next != null) { // 반환 값이 false 이면, 자기 다음 해결자에게 트러블을 떠넘긴다.
			next.support(trouble);
		} else { // 자기 뒤 처리자가 없으면...
			fail(trouble); // 미해결되었다고 출력한다.
		}
	}

	public String toString() { // 문자열 표현
		return "[" + name + "]";
	}

	protected abstract boolean resolve(Trouble trouble); // 해결용 메소드

	protected void done(Trouble trouble) { // 해결
		System.out.println(trouble + " is resolved by " + this + ".");
	}

	protected void fail(Trouble trouble) { // 미해결
		System.out.println(trouble + " cannot be resolved.");
	}
}
