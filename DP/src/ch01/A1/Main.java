package ch01.A1;

public class Main {
    public static void main(String[] args) {
    	// 책꽂이를 만든다.
        BookShelf bookShelf = new BookShelf(4);
        
        // 책을 만들어서 책꽂이에 넣는다
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        bookShelf.appendBook(new Book("East of Eden"));
        bookShelf.appendBook(new Book("Frankenstein"));
        bookShelf.appendBook(new Book("Gulliver's Travels"));
        bookShelf.appendBook(new Book("Hamlet"));
        
        // 책꽂이의 책을 하나씩 끄집어낼 Iterator를 얻는다.
        Iterator it = bookShelf.iterator();
        
        // Iterator의 hasNext( )와 next( ) 메소드를 이용하여 
        // 책을 하나씩 끄집어내서 책의 이름을 출력한다.
        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println("" + book.getName()); // 책의 이름을 얻어옴
        }
    }
}
