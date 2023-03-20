package hw.ch01;

public class Main {
    public static void main(String[] args) {
    	System.out.println("컴퓨터공학과 20200769 박지호");
    	System.out.println("----------------------------------");
    	
    	// 책꽂이를 만든다.
        BookShelf bookShelf = new BookShelf(6);
        
        // 책을 만들어서 책꽂이에 넣는다
        bookShelf.appendBook(new Book("자료구조론", "박우창"));
        bookShelf.appendBook(new Book("소프트웨어분석설계","최승훈"));
        bookShelf.appendBook(new Book("프로그래머수학","이주영"));
        bookShelf.appendBook(new Book("컴퓨터동작원리","유견아"));
        bookShelf.appendBook(new Book("컴퓨터그래픽스","이경미"));
        bookShelf.appendBook(new Book("해리포터","박지호"));
   
        // 책꽂이의 책을 하나씩 끄집어낼 Iterator를 얻는다.
        Iterator it = bookShelf.iterator();
        
        // Iterator의 hasNext( )와 next( ) 메소드를 이용하여 
        // 책을 하나씩 끄집어내서 책의 이름을 출력한다.
        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println("" + book.getName()+", " + book.getAuthor()); // 책의 이름과 저자를 얻어옴
        }
    }
}
