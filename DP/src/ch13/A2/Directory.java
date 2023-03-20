package ch13.A2;

import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {
    private String name;                    // ���丮�� �̸�
    private Vector dir = new Vector();      // ���丮 ��Ʈ���� ����
    public Directory(String name) {         // ������
        this.name = name;
    }
    public String getName() {               // �̸��� ��´�.
        return name;
    }
    public int getSize() {                  // ����� ��´�.
        SizeVisitor v = new SizeVisitor();  
        accept(v);                          
        return v.getSize();                 
    }
    public Entry add(Entry entry) {         // ��Ʈ���� �߰�
        dir.add(entry);
        return this;
    }
    public Iterator iterator() {
        return dir.iterator();
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
