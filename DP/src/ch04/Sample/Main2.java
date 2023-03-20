package ch04.Sample;

import ch04.Sample.framework.Factory;
import ch04.Sample.framework.Product;
import ch04.Sample.idcard.IDCard;
import ch04.Sample.idcard.IDCardFactory;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*직접 만드는 경우
		IDCard id01 = new IDCard("박지호");
		id01.use();
		System.out.println("owner: "+id01.getOwner());*/
		
		//공장을 세운다
		//IDCardFactory f = new IDCardFactory();
		Factory f = new IDCardFactory(); //부모 타입으로 선언: 확장성 있는 유연한 코드		
		
		//공장을 통해서 idcard를 얻어온다.
		//IDCard id02 = f.create("박지호");
		Product id02 = f.create("박지호");//부모 타입으로 선언
		id02.use();
		//Product 타입으로 변수를 선언했기 떄문에 다운캐스팅(형변환)
		System.out.println(((IDCard)id02).getOwner()); 
	}

}
