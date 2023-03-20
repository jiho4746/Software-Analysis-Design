package ch21.A1;

public class Printer implements Printable {
    private String name;
    public Printer() {
    	// ������ ���� �ɸ��� ��
        heavyJob("Printer�� �ν��Ͻ��� ������");
    }
    public Printer(String name) {                   // ������
        this.name = name;
        heavyJob("Printer�� �ν��Ͻ�(" + name + ")�� ������"); //������ ������ ���� �ð��� ���� �ɸ�
    }
    public void setPrinterName(String name) {       // �̸��� ����
        this.name = name;
    }
    public String getPrinterName() {                // �̸��� ���
        return name;
    }
    public void print(String string) {              // �̸��� �ٿ��� ǥ��
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }
    private void heavyJob(String msg) {             // ���ſ� �۾�
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("�Ϸ�");
    }
}
