package hw.ch05.idcard;

import hw.ch05.framework.*;

//�Ӽ����� �̸� �����ϴ� ���
public class IDCardFactoryParkJiHo1 extends Factory{
	//(3) �̸� God �ν��Ͻ��� ������ ����
	//static �Լ��� static �������� �̿�
	private static IDCardFactoryParkJiHo1 singleton = new IDCardFactoryParkJiHo1();

	//(1) �����ڸ� private���� �� (public�̸� ��� ������ �� ����)
	private IDCardFactoryParkJiHo1() {
	}

	//(2) God �ν��Ͻ��� ���� �޼ҵ带 ����
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
