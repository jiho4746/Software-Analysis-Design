package ch10.A4;

public class SortAndPrint {
    Comparable[] data;
    Sorter sorter;
    public SortAndPrint(Comparable[] data, Sorter sorter) {
        this.data = data;
        this.sorter = sorter;
    }
    public void execute() {
        print();
        //Player�� nexthand()�� ���� �� �ϰ� Strategy���� ��Ų ��ó��
        //sort()�� ���� �� �ϰ� sorter(=Strategy)���� �ñ�
        sorter.sort(data); //������ �̿��ؼ� ������ ��
        print();
    }
    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("");
    }
}
