package hw.ch22.command;

import java.util.Stack;
import java.util.Iterator;

public class MacroCommand implements Command {
    // ����� ����
    private Stack commands = new Stack();
    // ������ ����� ����
    private Stack commandsForRedo = new Stack();
    // ����
    public void execute() {
        Iterator it = commands.iterator();
        while (it.hasNext()) {
            ((Command)it.next()).execute();
        }
    }
    // �߰�
    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }
    // ������ ����� ����
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
    // ���� ����
    public void clear() {
        commands.clear();
    }
}
