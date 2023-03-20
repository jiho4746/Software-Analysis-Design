package ch05.Sample;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");

		// Singleton 객체를 두 번 얻어온다.
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

		// 두 개의 Singleton 객체의 주소가 같은지 비교한다.
        if (obj1 == obj2) {
            System.out.println("obj1과 obj2는 같은 인스턴스입니다.");
        } else {
            System.out.println("obj1과 obj2는 같은 인스턴스입니다.");
        }
        System.out.println("End.");
    }
}
