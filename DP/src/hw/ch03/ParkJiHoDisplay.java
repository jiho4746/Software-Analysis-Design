package hw.ch03;

//ParkJiHoDisplay�� AbstractDisplay�� ���� Ŭ����
public class ParkJiHoDisplay extends AbstractDisplay{
	// ǥ���ؾ� �� ���ڸ� �����Ѵ�.
		private String na;
		private String st;
		private int gr;

		public ParkJiHoDisplay(String name, String studentId, int grade) {
			this.na = name; // �ʵ�(�Ӽ�)�� ����� �д�.
			this.st = studentId;
			this.gr = grade;
		}

		// ���� Ŭ���������� �߻�޼ҵ忴��. ���⼭ �������̵� �ؼ� ����.
		public void open() {
			System.out.println("==========================");
			System.out.println("�������� ��ǻ�Ͱ��а�");
		}

		// print�޼ҵ�� ���⼭ �����Ѵ�. �̰��� display���� �ݺ��ؼ� ȣ��ȴ�.
		public void print() {
			System.out.println("�й� "+st+" / "+gr+"�г�"+" / "+na);//�ڱ� �̸��� �й� ���;
		}

		// close�޼ҵ嵵 ���⼭ ����
		public void close() {
			System.out.println("���ø� �޼ҵ� ���� �����Դϴ�");
			System.out.println("==========================");
		}
}
