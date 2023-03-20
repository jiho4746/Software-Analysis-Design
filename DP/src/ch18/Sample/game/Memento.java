package ch18.Sample.game;

import java.util.Vector;

// 게이머의 상태를 표현하는 클래스
// 객체의 상태 == 속성 값들의 집합
public class Memento {
	int money; // 현재 소유한 돈

	Vector fruits; // 현재 가지고 있는 과일

	// 생성자에 public이 없다 => package 접근 권한
	// 같은 패키지에 속하는 클래스에서만 호출할 수 있다.
	Memento(int money) { 
		this.money = money;
		this.fruits = new Vector();
	}

	public int getMoney() { // 돈을 얻는다.
		return money;
	}

	// 과일을 추가할 때 호출하는 메소드
	// package 접근 권한
	// => game 패키지 외부에서는 이 클래스의 내부 상태를 변경할 수 없다.
	void addFruit(String fruit) {
		fruits.add(fruit);
	}
}
