package ch21.Sample;

public class Main2 {

	public static void main(String[] args) {
		// ���� �� ���� Main()
		
		/*
		//���� (�ð��� ���� �ɸ�)
		Printable p1 = new Printer("p1"); //5�� ���� �ɸ�
		p1.print("����ȣ"); //p1�̶�� �����Ͱ� "����ȣ" ���
		*/
		
		//�븮���� ���� ���� ���� ó��
		//���� ���� �ϴ� �����Ρ� ��ü�� �������� �ʾ����� �����ϹǷ� ���� �ɸ�
		Printable p2 = new PrinterProxy("p2"); 
		p2.print2("����ȣ1"); //�븮���� ���� ��
		p2.print("����ȣ2"); //���� ���� -> ������ ���� ��
		p2.print3("a"); //ª�� �ָ� �븮���� ���� ��
		p2.print3("aaaaa"); //������ ������ �̹� ������ -> ��� �ָ� ������ ���� ��
	}
	public static void method(Printable p) { //����&�븮�� �Ѵ� ����(�θ�Ÿ������ ����)
		p.print("abc");
	}
}
