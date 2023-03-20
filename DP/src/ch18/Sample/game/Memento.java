package ch18.Sample.game;

import java.util.Vector;

// ���̸��� ���¸� ǥ���ϴ� Ŭ����
// ��ü�� ���� == �Ӽ� ������ ����
public class Memento {
	int money; // ���� ������ ��

	Vector fruits; // ���� ������ �ִ� ����

	// �����ڿ� public�� ���� => package ���� ����
	// ���� ��Ű���� ���ϴ� Ŭ���������� ȣ���� �� �ִ�.
	Memento(int money) { 
		this.money = money;
		this.fruits = new Vector();
	}

	public int getMoney() { // ���� ��´�.
		return money;
	}

	// ������ �߰��� �� ȣ���ϴ� �޼ҵ�
	// package ���� ����
	// => game ��Ű�� �ܺο����� �� Ŭ������ ���� ���¸� ������ �� ����.
	void addFruit(String fruit) {
		fruits.add(fruit);
	}
}
