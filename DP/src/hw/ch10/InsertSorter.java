package hw.ch10;

public class InsertSorter implements Sorter {
	//����ð��� ��� �Ӽ�
	long time;
	
	public void sort(Comparable[] data) {
		//���� �ð�
		long startTime = System.nanoTime();
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				//data�� �����̸� �ε�ȣ�� �� ����
				//data�� ��ü�̸� �޼ҵ带 �̿��ؼ� ���ؾ� ��
				//���ϴ� �޼ҵ� �̸�: compareTo()
				if (data[i].compareTo(data[j]) == -1) {
					// ���� ��ȯ�Ѵ�.
					Comparable passingplace = data[i];
					data[i] = data[j];
					data[j] = passingplace;
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
