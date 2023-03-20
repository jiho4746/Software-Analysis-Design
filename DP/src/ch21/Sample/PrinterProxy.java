package ch21.Sample;

// Printer Ŭ������ ���븮�Ρ��� ��Ÿ���� Ŭ����
public class PrinterProxy implements Printable {
	private String name; // �븮���� �̸��� ������

	private Printer real; // �����Ρ��� ���� ������ ������

	public PrinterProxy() {
	}

	public PrinterProxy(String name) { // ������
		this.name = name;
	}

	public synchronized void setPrinterName(String name) { // �̸��� ����
		if (real != null) { // "����"�� �̹� �����Ǿ� �ִٸ�...
			real.setPrinterName(name); // "����"���Ե� �̸��� �����Ѵ�.
		}
		this.name = name;
	}

	public String getPrinterName() { // �̸��� ���
		return name;
	}
	//�߰� �ڵ�-Main2
	public void print2(String string) {
		System.out.println("�븮��-print2(): "+string);
	}	
	//�߰� �ڵ�-Main2
	public void print3(String string) { //�˻�
		if(string.length()<=2) { //���̰� ª����
			System.out.println("�븮��-print3(): "+string); //�븮���� ���� ��
		} else if(real != null){ //���̰� ���
			real.print3(string); //������ ���� �� 
		}
	}	
	public void print(String string) { // ǥ��
		realize(); // �� ��, ������ �����ȴ�.
		real.print(string); // ���Ρ� ��ü�� print( ) �޼ҵ带 ȣ���Ѵ� => ����

	}

	// ���� ���� �ϴ� �����Ρ� ��ü�� �������� �ʾ����� �����Ѵ�.
	private synchronized void realize() { //������ �������� �ʱ� ���ؼ� synchronized
		if (real == null) {
			real = new Printer(name); //����
		}
	}
}
