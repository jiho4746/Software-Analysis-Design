package ch18.Sample;

import ch18.Sample.game.Memento;
import ch18.Sample.game.Gamer;

public class Main {
	public static void main(String[] args) {
		Gamer gamer = new Gamer(100); // 처음의 돈은 100
		// gamer.createMemento( )를 호출하여 현재 gamer의 상태를 얻어와서 보존한다.
		Memento memento = gamer.createMemento(); 
		
		for (int i = 0; i < 100; i++) {
			System.out.println("==== " + i); // 횟수 표시
			System.out.println("현 상태:" + gamer); // 현재의 주인공의 상태 표시

			gamer.bet(); // 게임을 진행 시킨다.

			System.out.println("돈은" + gamer.getMoney() + "원이 되었습니다.");

			// Memento를 어떻게 다룰 것인가를 결정한다.
			if (gamer.getMoney() > memento.getMoney()) { // 게이머가 돈이 증가했으면...
				System.out.println("    (많이 증가했으니 현재의 상태를 보존해두자)");
				memento = gamer.createMemento(); // 새로운 memento를 생성한다.
			} else if (gamer.getMoney() < memento.getMoney() / 2) { // 게이머의 돈이 반으로 줄었으면...
				System.out.println("    (많이 줄었으니 이전의 상태로 복귀하자)");
				gamer.restoreMemento(memento); // 이전 memento로 복귀한다.
			}

			// 시간을 기다림
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			System.out.println("");
		}
	}
}
