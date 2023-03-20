package ch23.Sample;

// <repeat command> ::= repeat <number> <command list>
// 에서 <repeat command>를 나타냄.
// repeat 2 go left end
public class RepeatCommandNode extends Node {
	// <number> 부분이 저장됨
	private int number; 

	// <command list> 부분이 저장됨
	private Node commandListNode;

	public void parse(Context context) throws ParseException {
		context.skipToken("repeat"); // 현재 toke이 "repeat"이면, 다음 토큰으로 진행시킨다.
		number = context.currentNumber(); // 현재 토큰을 숫자로 얻어온다.
		context.nextToken(); // 다음 토큰으로 이동시킨 다음,
		commandListNode = new CommandListNode(); // CommandListNode 객체에게 parse를 부탁한다.
		commandListNode.parse(context);
	}

	public String toString() {
		return "[repeat " + number + " " + commandListNode + "]";
	}
}
