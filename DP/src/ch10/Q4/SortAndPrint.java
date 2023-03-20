package ch10.Q4;

public class SortAndPrint {
	// Comparable: 크기 비교 가능한 클래스들이 구현하는 인터페이스
	//             String 클래스도 이 인터페이스를 구현했음.
    Comparable[] data;
    Sorter sorter;
    public SortAndPrint(Comparable[] data, Sorter sorter) {
        this.data = data;
        this.sorter = sorter;
    }
    public void execute() {
        print();
        sorter.sort(data);
        print();
    }
    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("");
    }
}
