package hw.ch01;

public class Main {
    public static void main(String[] args) {
    	System.out.println("��ǻ�Ͱ��а� 20200769 ����ȣ");
    	System.out.println("----------------------------------");
    	
    	// å���̸� �����.
        BookShelf bookShelf = new BookShelf(6);
        
        // å�� ���� å���̿� �ִ´�
        bookShelf.appendBook(new Book("�ڷᱸ����", "�ڿ�â"));
        bookShelf.appendBook(new Book("����Ʈ����м�����","�ֽ���"));
        bookShelf.appendBook(new Book("���α׷��Ӽ���","���ֿ�"));
        bookShelf.appendBook(new Book("��ǻ�͵��ۿ���","���߾�"));
        bookShelf.appendBook(new Book("��ǻ�ͱ׷��Ƚ�","�̰��"));
        bookShelf.appendBook(new Book("�ظ�����","����ȣ"));
   
        // å������ å�� �ϳ��� ����� Iterator�� ��´�.
        Iterator it = bookShelf.iterator();
        
        // Iterator�� hasNext( )�� next( ) �޼ҵ带 �̿��Ͽ� 
        // å�� �ϳ��� ������� å�� �̸��� ����Ѵ�.
        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println("" + book.getName()+", " + book.getAuthor()); // å�� �̸��� ���ڸ� ����
        }
    }
}
