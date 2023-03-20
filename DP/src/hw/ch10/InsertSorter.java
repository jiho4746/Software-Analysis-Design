package hw.ch10;

public class InsertSorter implements Sorter {
	//실행시간을 담는 속성
	long time;
	
	public void sort(Comparable[] data) {
		//현재 시각
		long startTime = System.nanoTime();
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				//data가 숫자이면 부등호로 비교 가능
				//data가 객체이면 메소드를 이용해서 비교해야 함
				//비교하는 메소드 이름: compareTo()
				if (data[i].compareTo(data[j]) == -1) {
					// 서로 교환한다.
					Comparable passingplace = data[i];
					data[i] = data[j];
					data[j] = passingplace;
				}
			}
		}
		//현재 시각
		long endTime = System.nanoTime();
		//실행시간 계산해서 속성에 담아둠
		time = endTime - startTime;
	}
	//실행시간을 얻어가는 메소드
		public long getTime() {
			return time;
		}
}
