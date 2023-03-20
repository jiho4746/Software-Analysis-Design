package ch18.Sample.game;

import java.util.Vector;
import java.util.Iterator;
import java.util.Random;

// 게임을 수행하는 게이머를 표현하는 클래스
public class Gamer {
	private int money; // 소유한 돈

	private Vector fruits = new Vector(); // 과일

	private Random random = new Random(); // 난수발생기

	private static String[] fruitsname = { // 과일 이름의 표
	"사과", "포도", "바나나", "귤", };

	public Gamer(int money) { // 생성자
		this.money = money;
	}

	public int getMoney() { // 현재의 돈을 얻는닫.
		return money;
	}

	public void bet() { // 게임을 진행시킬 때 호출하는 메소드
		int dice = random.nextInt(6) + 1; // 주사위를 던진다.
		
		if (dice == 1) { // 1이 나온다...돈이 증가한다.
			money += 100;
			System.out.println("돈이 증가했습니다.");
		} else if (dice == 2) { // 2가 나온다...돈이 반으로 준다.
			money /= 2;
			System.out.println("돈이 반으로 줄었습니다.");
		} else if (dice == 6) { // 6이 나온다...과일을 받는다.
			String f = getFruit();
			System.out.println("과일(" + f + ")을 받았습니다.");
			fruits.add(f);
		} else { // 그 밖에...아무 일도 일어나지 않는다.
			System.out.println("아무일도 일어나지 않았습니다.");
		}
	}

	// 이 메소드가 호출되면, 현재 상태를 보존하는 Memento 객체가 생성된다.
    // 현재 돈과 맛있는 과일들 만을 Memento 객체에 보존한다.(스냅샷을 찍는다.)
	// 찰칵하고 사진을 찍듯이 현재의 상태를 Memento 인스턴스에 보존해 두는 것이다.
	public Memento createMemento() { 
		Memento m = new Memento(money); // 돈을 보존한다.
		
		// 과일을 보존한다.
		Iterator it = fruits.iterator();
		while (it.hasNext()) {
			String f = (String) it.next();
			if (f.startsWith("맛있다.")) { // 과일은 맛있는 것만 보존
				m.addFruit(f);
			}
		}
		return m;
	}

	// undo를 실행한다.
	// 입력인자로 들어온 Memento 객체로부터 보존되었던 돈과 과일을 얻어온다.
	public void restoreMemento(Memento memento) { 
		this.money = memento.money;
		this.fruits = memento.fruits;
	}

	public String toString() { // 문자열 표현
		return "[money = " + money + ", fruits = " + fruits + "]";
	}

	 // 과일을 1개 얻는다.
	private String getFruit() {
		String prefix = "";
		// 선택적으로 ‘맛있다’를 과일이름 앞에 붙인다.
		if (random.nextBoolean()) { 
			prefix = "맛있다.";
		}
		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}
}
