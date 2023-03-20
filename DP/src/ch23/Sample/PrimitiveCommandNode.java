package ch23.Sample;

// <primitive command> ::= go | right | left에서 < primitive command >를 나타냄
// 예: go
public class PrimitiveCommandNode extends Node {
	private String name;

	// 다른 parse( ) 메소드를 호출하지 않는다.
	public void parse(Context context) throws ParseException {
		name = context.currentToken();
		// 현재 토큰이 name하고 같은지 확인하고 다음 토큰으로 건너띄어라.
		context.skipToken(name); 
		// 얻은 토큰이 “go”, “right”, “left” 중에 하나가 아니면, 
		if (!name.equals("go") && !name.equals("right") && !name.equals("left")) { 
			throw new ParseException(name + " is undefined"); // 예외를 발생시킨다.
		}
	}

	public String toString() {
		return name;
	}
}
