package ch17.Sample;

import java.util.Vector;
import java.util.Iterator;

// 수를 생성하는 클래스
public abstract class NumberGenerator {
	// NumberGenerator를 관찰하고 있는 Observer들을 보관하고 있는 필드
	private Vector observers = new Vector(); 

	// Observer를 추가할 때 호출하는 메소드
	public void addObserver(Observer observer) { // Observer를 추가
		observers.add(observer);
	}

	// Observer를 삭제할 때 호출하는 메소드
	public void deleteObserver(Observer observer) { // Observer를 삭제
		observers.remove(observer);
	}

	// Observer 전원에게, “나의 내용이 갱신되었기 때문에 
	// 당신의 표시도 갱신해주세요”라고 알려주는 메소드
	public void notifyObservers() { 
		Iterator it = observers.iterator();
		// Observer들의 update(this) 메소드를 차례차례 호출한다.
		while (it.hasNext()) {
			Observer o = (Observer) it.next();
			o.update(this);
		}
	}

	public abstract int getNumber(); // 수를 취득한다.

	public abstract void execute(); // 수를 생성한다.
}
