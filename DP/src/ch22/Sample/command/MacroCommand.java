package ch22.Sample.command;

import java.util.Stack;
import java.util.Iterator;

// ‘여러 개의 명령을 한데 모은 명령’을 나타냄
// Composite 패턴이 사용됨
// => 여러 개의 명령을 모은 것(container)이면서, 
// 그 자체가 하나의 명령(content)가 된다.
public class MacroCommand implements Command {
	// 다수의 Command를 모아둠
	// Stack: 나중에 들어간 원소가 먼저 나오는 자료구조체
	private Stack commands = new Stack(); // Vector, ArrayList, HashMap..

	// 실행
	public void execute() {
		// 자신이 가지고 있는 모든 명령의 execute( )을 호출한다(실행한다)
		Iterator it = commands.iterator();
		while (it.hasNext()) {
			((Command) it.next()).execute();
		}
		// 자신이 가지고 있는 명령이 MacroCommand이면, 
		// 그 MacroCommand가 가지고 있는 명령들의 execute( )이 차례대로 실행된다.
		// (recursive call)

	}

	// MacroCommand 클래스에 
	// 새로운 Command(Command 인터페이스를 구현한 클래스의 인스턴스)를 
	// 추가하는 메소드
	public void append(Command cmd) {
		// 실수로 자기 자신을 추가하지 않도록 체크함
		// 자기 자신이 추가되면, execute( ) 실행 시 무한 루프가 돌게 된다.
		if (cmd != this) {
			commands.push(cmd); // Stack 클래스의 push( )를 이용함
		}
	}

	// commands의 마지막 명령을 삭제하는 메소드
	public void undo() {
		if (!commands.empty()) {
			commands.pop();
		}
	}

	// commands 의 모든 명령을 삭제하는 메소드
	public void clear() {
		commands.clear();
	}
}
