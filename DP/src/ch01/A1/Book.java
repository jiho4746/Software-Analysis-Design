package ch01.A1;

// 책을 나타내는 클래스
public class Book {
	// 책이름을 저장하는 변수
    private String name = "";
    public Book(String name) {
        this.name = name;
    }
    // 책의 이름을 얻어올 때 호출하는 메소드
    public String getName() {
        return name;
    }
}
