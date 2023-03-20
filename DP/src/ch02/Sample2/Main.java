package ch02.Sample2;

//Main(client) 이 필요로하는 메소드가 선언되어 있음
public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
