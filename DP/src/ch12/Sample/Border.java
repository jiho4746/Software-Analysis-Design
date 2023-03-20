package ch12.Sample;

// ‘장식’을 나타내는 추상 클래스
// StringDisply와 Border는 모두 Display의 하위 클래스이다. 
// => StringDisplay(내용물)가 Border(장식자)를 동일시한다.
// => 즉, 장식자도 또다른 장식자의 내용물이 될 수 있다.
public abstract class Border extends Display {
	//[장식 대상을 가지고 있음]
	protected Display display; // 장식이 감싸고 있는 "내용물"을 가리킨다.
	                           // StringDisplay 뿐 만 아니라 Border 도 참조할 수 있다.
	                           // 이유: Border도 Display의 하위 클래스이므로

	protected Border(Display display) { // 인스턴스 생성시에 "내용물"을 인수로 지정
		this.display = display;
	}
}
