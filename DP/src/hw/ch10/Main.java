package hw.ch10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student[] data = new Student[5]; //객체 배열
        data[0] = new Student("박지호", "20200769", 169);
        data[1] = new Student("일지매", "20200123", 171);
        data[2] = new Student("이지매", "20200456", 176);
        data[3] = new Student("삼지매", "20200789", 183);
        data[4] = new Student("네지매", "20200012", 188);
        
    	System.out.println("컴퓨터공학과 20200769 박지호");
    	System.out.println("----------------------------------");
    	
    	System.out.println("<정렬결과>");
    	System.out.println("(1) by InsertSorter");
    	System.out.println("[실행전]");
    	for(int i=0; i<data.length; i++) { //정렬전
    		System.out.println(data[i]); //toString() 자동으로 호출됨
    	}
    	System.out.println();
    	System.out.println("[실행후]");
    	SortAndPrint sap = new SortAndPrint(data, new InsertSorter());
    	sap.execute();
    	for(int i=0; i<data.length; i++) { //정렬후
    		System.out.println(data[i]); //toString() 자동으로 호출됨
    	}
    	System.out.println("* execution time:"+sap.getTime());
    	
    	System.out.println();
    	System.out.println("(2) by BubbleSorter");
    	Arrays.sort(data); //오름차순 정렬 sort() 사용
    	System.out.println("[실행전]");
    	for(int i=0; i<data.length; i++) { //정렬전
    		System.out.println(data[i]); //toString() 자동으로 호출됨
    	}
    	System.out.println();
    	System.out.println("[실행후]");
    	SortAndPrint sap1 = new SortAndPrint(data, new BubbleSorter());
    	sap1.execute();
    	for(int i=0; i<data.length; i++) { //정렬후
    		System.out.println(data[i]); //toString() 자동으로 호출됨
    	}
    	System.out.println("* execution time:"+sap1.getTime());
    }
}
