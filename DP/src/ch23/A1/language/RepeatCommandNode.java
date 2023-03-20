package ch23.A1.language;

// <repeat command> ::= repeat <number> <command list>
public class RepeatCommandNode extends Node {
    private int number;
    private Node commandListNode;
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    public void execute() throws ExecuteException {
    	// number 만큼 반복해서 commandListNode의 execute()을 호출한다.
        for (int i = 0; i < number; i++) {
            commandListNode.execute();
        }
    }
    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }
}
