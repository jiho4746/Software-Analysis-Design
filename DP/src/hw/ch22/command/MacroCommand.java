package hw.ch22.command;

import java.util.Stack;
import java.util.Iterator;

public class MacroCommand implements Command {
    // 명령의 집합
    private Stack commands = new Stack();
    // 삭제한 명령의 집합
    private Stack commandsForRedo = new Stack();
    // 실행
    public void execute() {
        Iterator it = commands.iterator();
        while (it.hasNext()) {
            ((Command)it.next()).execute();
        }
    }
    // 추가
    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }
    // 최후의 명령을 삭제
    public void undo() {
    	if (!commands.empty()) {
    		Command delete = (Command)commands.peek();
    		commandsForRedo.push(delete);
        	commands.pop();
        }
    }
    public void redo() {  
    	if (!commandsForRedo.empty()) {
    		Command restoration = (Command)commandsForRedo.peek();
    		commands.push(restoration);
    		commandsForRedo.pop();
        }
    }
    // 전부 삭제
    public void clear() {
        commands.clear();
    }
}
