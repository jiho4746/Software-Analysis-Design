package ch23.Sample;

// <command> ::= <repeat command> | <primitive command> 에서 <command>를 나타냄
public class CommandNode extends Node {
	// RepeatCommandNode 또는 PrimitiveCommandNode의 인스턴스를 넣어두는 변수
	private Node node;

	public void parse(Context context) throws ParseException {
		
		if (context.currentToken().equals("repeat")) { // "repeat" 로 시작되면...
			node = new RepeatCommandNode(); // RepeatCommandNode 인스턴스를 생성한 후 
			node.parse(context); // 그것의 parse( )를 호출한다.
		} else { // "repeat"로 시작하지 않으면...
			node = new PrimitiveCommandNode(); // PrimitiveCommandNode 인스턴스를 생성한 후
			node.parse(context); // 그것의 parse( )를 호출한다.
		}
	}

	public String toString() {
		return node.toString();
	}
}
