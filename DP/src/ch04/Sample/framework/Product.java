package ch04.Sample.framework;

// 구체적인 제품들이 가져야 메소드를 정의한 추상 클래스
public abstract class Product {
	//연습문제4-3 : 인자 없는 생성자가 기본적으로 만들어짐
    public abstract void use();
    
    /*연습문제 4-3
    public abstract Product(int a); //생성자 선언 -> 상속되지 않으므로 아무 의미가 없음*/
}
