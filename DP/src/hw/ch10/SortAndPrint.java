package hw.ch10;

public class SortAndPrint {
	// Comparable: ũ�� �� ������ Ŭ�������� �����ϴ� �������̽�
	//             String Ŭ������ �� �������̽��� ��������.
    Comparable[] data;
    Sorter sorter;
    public SortAndPrint(Comparable[] data, Sorter sorter) {
        this.data = data;
        this.sorter = sorter;
    }
    public void execute() {
        //Player�� nexthand()�� ���� �� �ϰ� Strategy���� ��Ų ��ó��
        //sort()�� ���� �� �ϰ� sorter(=Strategy)���� �ñ�
        sorter.sort(data); //������ �̿��ؼ� ������ ��
    }
    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("");
    }
	public long getTime() {
		return sorter.getTime();
	}
}
