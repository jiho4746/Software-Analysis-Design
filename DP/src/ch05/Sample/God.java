package ch05.Sample;

//�ν��Ͻ��� 1���� �����ǵ��� �Ϸ��� ��
public class God {
	
	//(3) �̸� God �ν��Ͻ��� ������ ����
	//static �Լ��� static �������� �̿�
	private  static God g = new God(); //Ŭ���� �ε� �� ��ü�� �̸� �������
	
	//(1) �����ڸ� private���� �� (public�̸� ��� ������ �� ����)
	private God() {
		System.out.println("God�� ������");
	}
	
	//(2) God �ν��Ͻ��� ���� �޼ҵ带 ����
	public static God getInstance() { //static -> Ŭ������ ���ϴ� �޼ҵ�
		return g;
	}
}
