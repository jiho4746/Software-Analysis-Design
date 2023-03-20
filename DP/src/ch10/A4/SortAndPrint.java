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
        //Player가 nexthand()를 직접 안 하고 Strategy한테 시킨 것처럼
        //sort()를 직접 안 하고 sorter(=Strategy)한테 맡김
        sorter.sort(data); //전략을 이요해서 소팅을 함
        print();
    }
    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("");
    }
}
