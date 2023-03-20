package hw.ch10;

import java.time.LocalTime;

public class BubbleSorter implements Sorter {
	//����ð��� ��� �Ӽ�
	long time;
	
	@Override
	public void sort(Comparable[] data) {
		//���� �ð�
		long startTime = System.nanoTime();

		for (int i = 0; i < data.length; i++) { 
			//�� ���� ��Ƚ���� �迭 ũ���� ���� ���带 �� ��ŭ ��
			for (int j = 0; j < data.length-1-i; j++) { 
				if (data[j].compareTo(data[j+1]) == -1) { // data[j] �� data[j+1] ���� ũ��
					Comparable passingplace = data[j];
					data[j] = data[j+1];
					data[j+1] = passingplace;
				}
			}
		}
		//���� �ð�
		long endTime = System.nanoTime();
		//����ð� ����ؼ� �Ӽ��� ��Ƶ�
		time = endTime - startTime;
	}
	//����ð��� ���� �޼ҵ�
	public long getTime() {
		return time;
	}
}
