package ch04.Sample.idcard;

import ch04.Sample.framework.*;

public class IDCard extends Product {
    private String owner;

    // private이나 public 으로 선언되어 있지 않으면, 
    // 같은 패키지에 속한 클래스들만이 이 생성자를 호출할 수 있다.
    IDCard(String owner) {
    	//연습문제 4-3 : 부모의 인자 없는 생성자를 먼저 호출함
    	//super(a, b);
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }
    
    /*Main2-직접 만드는 경우
    public IDCard(String owner) {
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }*/
    public void use() {
        System.out.println(owner + "의 카드를 사용합니다.");
    }
    public String getOwner() {
        return owner;
    }
}
