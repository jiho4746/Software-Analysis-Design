package hw.ch01;

// 책을 나타내는 클래스
public class Book {
	// 책이름을 저장하는 변수
    private String name = "";
    private String author = "";
    
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    // 책의 이름을 얻어올 때 호출하는 메소드
    public String getName() {
        return name;
    }
 // 책의 저자를 얻어올 때 호출하는 메소드
    public String getAuthor() {
        return author;
    }
}
