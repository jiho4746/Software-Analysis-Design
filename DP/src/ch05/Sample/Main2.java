package ch05.Sample;

public class Main2 {

	public static void main(String[] args) {
		// God �ν��Ͻ��� ���� (��ü ���� ���� Ŭ������ �޼ҵ� ȣ��)
		God g1 = God.getInstance();
		God g2 = God.getInstance(); 
		//g1, g2 ��� God �ν��Ͻ��� �ּҰ� ���->�Ȱ��� ��ü ����
		
		// ���� ������ ��
		if(g1 == g2) {
			System.out.println("���� ����");
		}
		else {
			System.out.println("���� �ٸ�");
		}
	}

}
