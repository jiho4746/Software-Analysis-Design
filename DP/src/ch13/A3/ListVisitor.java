package ch13.A3;

import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String currentdir = "";                         // ���� �ָ��ϰ� �ִ� ���丮��
    public void visit(File file) {                  // ������ �湮���� �� ȣ��ȴ�.
        System.out.println(currentdir + "/" + file);
    }
    public void visit(Directory directory) {   // ���丮�� �湮���� �� ȣ��ȴ�.
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
