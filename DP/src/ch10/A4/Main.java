package ch10.A4;

public class Main {
    public static void main(String[] args) {
        String[] data = {
            "Dumpty", "Bowman", "Carroll", "Elfland", "Alice",
        };
        SortAndPrint sap = new SortAndPrint(data, new QuickSorter()); //어떤 전략을 사용할지 만듦
        sap.execute();
    }
}
