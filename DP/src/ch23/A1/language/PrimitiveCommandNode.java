package ch23.A1.language;

// <primitive command> ::= go | right | left
public class PrimitiveCommandNode extends Node {
	private String name;

	private Executor executor;

	public void parse(Context context) throws ParseException {
		name = context.currentToken();
		context.skipToken(name);
		// 파싱할 때, 해당 executor를 만든다.
		executor = context.createExecutor(name);
	}

	public void execute() throws ExecuteException {
		if (executor == null) {
			throw new ExecuteException(name + ": is not defined");
		} else {
			// 이 때, executor에게 실행을 명령한다.
			// => 그러면, executor의 execute( ) 이 실행된다.
			executor.execute();
		}
	}

	public String toString() {
		return name;
	}
}
