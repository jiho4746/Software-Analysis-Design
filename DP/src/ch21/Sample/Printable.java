package ch21.Sample;
public interface Printable {
    public abstract void setPrinterName(String name);   // �̸��� ����
    public abstract String getPrinterName();            // �̸��� ���
    public abstract void print(String string);          // ���ڿ� ǥ��(����Ʈ�ƿ�)
	public abstract void print2(String string); //�߰� �ڵ�-Main2
	public abstract void print3(String string); //�߰� �ڵ�-Main2
}
