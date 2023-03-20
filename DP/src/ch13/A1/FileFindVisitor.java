package ch13.A1;

import java.util.Iterator;
import java.util.Vector;

public class FileFindVisitor extends Visitor {
    private String filetype;
    private Vector found = new Vector();
    public FileFindVisitor(String filetype) {           // ".txt"ó�� Ȯ���ڸ� .�� �ٿ� ����
        this.filetype = filetype;
    }
    public Iterator getFoundFiles() {                   // �߰��� ������ ��´�.
        return found.iterator();
    }
    public void visit(File file) {                  // ������ �湮���� ���� ȣ��ȴ�.
        if (file.getName().endsWith(filetype)) {
            found.add(file);
        }
    }
    public void visit(Directory directory) {   // ���丮�� �湮���� �� ȣ��ȴ�.
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.accept(this);
        }
    }
}
