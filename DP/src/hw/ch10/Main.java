package hw.ch10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student[] data = new Student[5]; //��ü �迭
        data[0] = new Student("����ȣ", "20200769", 169);
        data[1] = new Student("������", "20200123", 171);
        data[2] = new Student("������", "20200456", 176);
        data[3] = new Student("������", "20200789", 183);
        data[4] = new Student("������", "20200012", 188);
        
    	System.out.println("��ǻ�Ͱ��а� 20200769 ����ȣ");
    	System.out.println("----------------------------------");
    	
    	System.out.println("<���İ��>");
    	System.out.println("(1) by InsertSorter");
    	System.out.println("[������]");
    	for(int i=0; i<data.length; i++) { //������
    		System.out.println(data[i]); //toString() �ڵ����� ȣ���
    	}
    	System.out.println();
    	System.out.println("[������]");
    	SortAndPrint sap = new SortAndPrint(data, new InsertSorter());
    	sap.execute();
    	for(int i=0; i<data.length; i++) { //������
    		System.out.println(data[i]); //toString() �ڵ����� ȣ���
    	}
    	System.out.println("* execution time:"+sap.getTime());
    	
    	System.out.println();
    	System.out.println("(2) by BubbleSorter");
    	Arrays.sort(data); //�������� ���� sort() ���
    	System.out.println("[������]");
    	for(int i=0; i<data.length; i++) { //������
    		System.out.println(data[i]); //toString() �ڵ����� ȣ���
    	}
    	System.out.println();
    	System.out.println("[������]");
    	SortAndPrint sap1 = new SortAndPrint(data, new BubbleSorter());
    	sap1.execute();
    	for(int i=0; i<data.length; i++) { //������
    		System.out.println(data[i]); //toString() �ڵ����� ȣ���
    	}
    	System.out.println("* execution time:"+sap1.getTime());
    }
}
