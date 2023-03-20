package ch23.Sample;

import java.util.Vector;

// <command list> ::= <command>* end 에서 <command list>을 나타냄
// 예: repeat 2 go left end go end
public class CommandListNode extends Node {
	// 0번 이상 반복 출현하는 <command>를 보관함
	// <command>에 대응하는 CommandNode 클래스의 인스턴스를 넣어둠
	private Vector list = new Vector(); 

	public void parse(Context context) throws ParseException {
		// <Command> 가 여러 개 나올 수 있으므로, while-loop를 돌린다.
		while (true) {
			if (context.currentToken() == null) { // 남은 토큰이 없다면(null)
				throw new ParseException("Missing 'end'"); // ‘end’가 빠졌다는 예외를 발생시킴.
			} else if (context.currentToken().equals("end")) { // 현재 토큰이 ‘end’라면
				context.skipToken("end");  // ‘end’ 다음 토큰으로 진행시킨 후,  while 루프를 빠져나온다.
				break; 
			} else { // 현재 토큰이 ‘end’가 아니라면 => 이 때는 <command>를 의미하므로, 
				Node commandNode = new CommandNode();  // CommandNode의 인스턴스를 만들어서 
				commandNode.parse(context);  // 그것의 parse( )호출한 후,
				list.add(commandNode); //  list에 추가한다.
			}
		}
	}

	public String toString() {
		return "" + list;
	}
}
