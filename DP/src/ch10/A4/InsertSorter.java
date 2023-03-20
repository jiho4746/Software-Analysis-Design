package ch10.A4;

public class InsertSorter implements Sorter {
	public void sort(Comparable[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				//data가 숫자이면 부등호로 비교 가능
				//data가 객체이면 메소드를 이용해서 비교해야 함
				//비교하는 메소드 이름: compareTo()
				if (data[i].compareTo(data[j]) > 0) { // data[i] 가 data[j] 보다 크면
					// 서로 교환한다.
					Comparable passingplace = data[i];
					data[i] = data[j];
					data[j] = passingplace;
				}
			}
		}
	}
}
