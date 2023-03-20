package ch23.Sample;

// <program> ::= program <command list> 에서 <program>를 나타냄
// 예: program repeat 2 go left end go end
public class ProgramNode extends Node {
	// 자신의 뒤에 이어지는 <command list>에 대응하는 구조(노드)를 보관함
	private Node commandListNode;

	public void parse(Context context) throws ParseException {
		// 현재 토큰이 "program"인지 확인한다.
		context.skipToken("program");
		// 나머지 부분은, CommandListNode에게 parse를 부탁한다.
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	}

	public String toString() {
		// commandListNode의 toString( )이 자동으로 호출된다.
		return "[program " + commandListNode + "]";
	}
}
