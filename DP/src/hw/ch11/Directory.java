package hw.ch11;

import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {
	private String name;
	private String date;
	private String author;
	
	private Vector directory = new Vector(); // ���丮 ��Ʈ���� ����

	public Directory(String name, String date, String author) { // ������
		this.name = name;
		this.date = date;
		this.author = author;
	}
	public int getCount() {
		int size = 0;
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next(); 
			size+=entry.getCount();
			}return size;
	}
	public String getName() { // �̸��� ��´�.
		return name;
	}

	public int getSize() { // ����� ��´�.
		int size = 0;
		// �ڽ��� ������ �ִ� ��� ��Ʈ���� ���ؼ�, getSize( )ȣ���Ͽ� ���Ѵ�.
		Iterator it = directory.iterator();
		while (it.hasNext()) { //���Ұ� �� �ִ��� Ȯ���ϰ� �ִٸ� ������
			// entry�� Entry Ÿ������ ����Ǿ� �ְ�,
			// Entry�� File�̳� Directory�� �θ� Ŭ�����̱� ������ �� �� ������ �� �ִ�.
			Entry entry = (Entry) it.next(); //Object�� Entry�� Ÿ��ĳ����
			// entry�� ���丮�� ��쿡��, �ٽ� �� ���丮�� getSize( )�� ��������� ȣ��ȴ�. 
			size += entry.getSize(); 
			// => �׸��� ���빰�� ���Ͻ� �ȴ�.
		}
		return size;
	}
	//�������� �þ -> ���� ���
	public Entry add(Entry entry) { // ��Ʈ���� �߰�
		// �Է����ڷ� ���� Entry(File �Ǵ� Directory ��ü)�� ���Ϳ� �����Ѵ�.
		//�θ�Ÿ�� Entry����!!
		directory.add(entry);
		return this;
	}

	protected void printList(String prefix) { // ��Ʈ���� �϶�
		System.out.println(prefix + "/" + this);
		// �ڽ��� ������ �ִ� ��� ��Ʈ���� ���ؼ�, printList( )ȣ���Ѵ�.
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			entry.printList(prefix + "/" + name);
		}
	}
	@Override
	public String getDate() {
		return date;
	}
	@Override
	public String getAuthor() {
		return author;
	}
}
