package ch17.Sample;

// 관찰자를 표현하는 인터페이스
public interface Observer {
	// NumberGenerator가 “나의 내용이 갱신되었습니다. 
	// 표시도 갱신해주세요” 라고 관찰자에게 알려줄 때 호출하는 메소드
	public abstract void update(NumberGenerator generator);
}
