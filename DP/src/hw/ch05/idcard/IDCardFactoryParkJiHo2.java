package hw.ch05.idcard;

import hw.ch05.framework.*;

public class IDCardFactoryParkJiHo2 extends Factory{
	private static IDCardFactoryParkJiHo2 singleton = null;

	private IDCardFactoryParkJiHo2() {
		slowdown();  // 생성 시 3초간 쉰다.        
	}

	synchronized public static IDCardFactoryParkJiHo2 getInstance() {
	//public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new IDCardFactoryParkJiHo2();
		}
		return singleton;
	}

	private void slowdown() {
		try {
			Thread.sleep(3000);  
		} catch (InterruptedException e) {
		}
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
