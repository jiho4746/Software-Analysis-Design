package hw.ch01;

// å�� ��Ÿ���� Ŭ����
public class Book {
	// å�̸��� �����ϴ� ����
    private String name = "";
    private String author = "";
    
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    // å�� �̸��� ���� �� ȣ���ϴ� �޼ҵ�
    public String getName() {
        return name;
    }
 // å�� ���ڸ� ���� �� ȣ���ϴ� �޼ҵ�
    public String getAuthor() {
        return author;
    }
}
