package ch10.Sample;

public class Main2 {

	public static void main(String[] args) {
		/*
		Hand h1 = new Hand(Hand.HANDVALUE_GUU); //�ָ�
		Hand h2 = new Hand(Hand.HANDVALUE_PAA); //��
		
		if (h1.isStrongerThan(h2)) {
			System.out.println("h1�� �̱��");
		}
		if (h1.isWeakerThan(h2)) {
			System.out.println("h1�� ����");
		}
		System.out.println(h1.toString()); //���� �� ���
		*/
		
		Player p1 = new Player("����ȣ", new ProbStrategy(100));
		Player p2 = new Player("���缮", new WinningStrategy(200));
		
		for(int i=0; i<=10000; i++) { //���������� 100�� ����
			//�� 2���� ����� ������ ����
			Hand h1 = p1.nextHand();
			Hand h2 = p2.nextHand();
			
			if(i==5000) {
				p2.setStrategy(new ProbStrategy(300)); //���� �߿� Strategy ���� ����
			}
			
			if (h1.isStrongerThan(h2)) {
				System.out.println("Winner: "+p1);
				p1.win(); //�̰����� �˸�
				p2.lose(); //������ �˸�
			}
			else if(h2.isStrongerThan(h1)) {
				System.out.println("Winner: "+p2);
				p2.win(); 
				p1.lose(); 
			}
			else {
				System.out.println("Even");
				p1.even(); //������� �˸�
				p2.even();
			}
		}
		System.out.println("Total result: ");
		System.out.println(" "+ p1); // p1.toString() �ڵ����� ȣ���
		System.out.println(p2); // p2.toString() �ڵ����� ȣ���
	}
}
