package hw.ch05.idcard;

import hw.ch05.framework.*;

//속성에서 미리 생성하는 방식
public class IDCardFactoryParkJiHo1 extends Factory{
	//(3) 미리 God 인스턴스를 생성해 놓음
	//static 함수는 static 변수만을 이용
	private static IDCardFactoryParkJiHo1 singleton = new IDCardFactoryParkJiHo1();

	//(1) 생성자를 private으로 함 (public이면 계속 생성할 수 있음)
	private IDCardFactoryParkJiHo1() {
	}

	//(2) God 인스턴스를 얻어가는 메소드를 만듦
	public static IDCardFactoryParkJiHo1 getInstance() {
		return singleton;
	}

	@Override
	protected Product createProduct(String owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void registerProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
}
