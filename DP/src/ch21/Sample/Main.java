package ch21.Sample;

// PrinterProxy�� �����ؼ�, Printer�� �̿��ϴ� Ŭ����
public class Main {
	public static void main(String[] args) {
		// ����, PrinterProxy ���� �Ѵ�. (�븮�� ����)
		Printable p = new PrinterProxy("Alice");
		System.out.println("������ �̸���" + p.getPrinterName() + "�Դϴ�.");
		
		// '����'�� �̸��� Bob���� �����Ѵ�.
		p.setPrinterName("Bob"); //�븮���� ���� ��
		System.out.println("������ �̸���" + p.getPrinterName() + "�Դϴ�."); //�븮���� ���� ��

		// ���������� ������ Printer��ü�� �������� �ʾҴ�.
		// ��, �븮���� PrinterProxy ��ü�� ���� �Ѵ�.

		p.print("Hello, world."); // �� ������ ����� ��, ��μ� ������ Printer ��ü�� ���������.
		                                       // �ʿ��� �� ��μ� �����ȴ�.

	}
}
