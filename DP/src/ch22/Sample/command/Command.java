package ch22.Sample.command;

// ‘명령’을 표현하기 위한 인터페이스
public interface Command {
	// 무언가를 실행하는 메소드
	// 구체적으로 무슨 일을 하는지는 
	// Command 인터페이스를 구현한 클래스가 결정한다.
	public abstract void execute();
}
