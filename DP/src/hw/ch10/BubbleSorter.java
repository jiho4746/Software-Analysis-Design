package hw.ch10;

import java.time.LocalTime;

public class BubbleSorter implements Sorter {
	//실행시간을 담는 속성
	long time;
	
	@Override
	public void sort(Comparable[] data) {
		//현재 시각
		long startTime = System.nanoTime();

		for (int i = 0; i < data.length; i++) { 
			//각 라운드 비교횟수는 배열 크기의 현재 라운드를 뺀 만큼 비교
			for (int j = 0; j < data.length-1-i; j++) { 
				if (data[j].compareTo(data[j+1]) == -1) { // data[j] 가 data[j+1] 보다 크면
					Comparable passingplace = data[j];
					data[j] = data[j+1];
					data[j+1] = passingplace;
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
