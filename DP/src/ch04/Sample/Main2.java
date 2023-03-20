package ch04.Sample;

import ch04.Sample.framework.Factory;
import ch04.Sample.framework.Product;
import ch04.Sample.idcard.IDCard;
import ch04.Sample.idcard.IDCardFactory;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*���� ����� ���
		IDCard id01 = new IDCard("����ȣ");
		id01.use();
		System.out.println("owner: "+id01.getOwner());*/
		
		//������ �����
		//IDCardFactory f = new IDCardFactory();
		Factory f = new IDCardFactory(); //�θ� Ÿ������ ����: Ȯ�强 �ִ� ������ �ڵ�		
		
		//������ ���ؼ� idcard�� ���´�.
		//IDCard id02 = f.create("����ȣ");
		Product id02 = f.create("����ȣ");//�θ� Ÿ������ ����
		id02.use();
		//Product Ÿ������ ������ �����߱� ������ �ٿ�ĳ����(����ȯ)
		System.out.println(((IDCard)id02).getOwner()); 
	}

}
