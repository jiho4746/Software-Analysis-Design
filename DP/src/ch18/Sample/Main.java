package ch18.Sample;

import ch18.Sample.game.Memento;
import ch18.Sample.game.Gamer;

public class Main {
	public static void main(String[] args) {
		Gamer gamer = new Gamer(100); // ó���� ���� 100
		// gamer.createMemento( )�� ȣ���Ͽ� ���� gamer�� ���¸� ���ͼ� �����Ѵ�.
		Memento memento = gamer.createMemento(); 
		
		for (int i = 0; i < 100; i++) {
			System.out.println("==== " + i); // Ƚ�� ǥ��
			System.out.println("�� ����:" + gamer); // ������ ���ΰ��� ���� ǥ��

			gamer.bet(); // ������ ���� ��Ų��.

			System.out.println("����" + gamer.getMoney() + "���� �Ǿ����ϴ�.");

			// Memento�� ��� �ٷ� ���ΰ��� �����Ѵ�.
			if (gamer.getMoney() > memento.getMoney()) { // ���̸Ӱ� ���� ����������...
				System.out.println("    (���� ���������� ������ ���¸� �����ص���)");
				memento = gamer.createMemento(); // ���ο� memento�� �����Ѵ�.
			} else if (gamer.getMoney() < memento.getMoney() / 2) { // ���̸��� ���� ������ �پ�����...
				System.out.println("    (���� �پ����� ������ ���·� ��������)");
				gamer.restoreMemento(memento); // ���� memento�� �����Ѵ�.
			}

			// �ð��� ��ٸ�
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			System.out.println("");
		}
	}
}
