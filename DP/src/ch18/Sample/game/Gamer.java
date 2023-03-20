package ch18.Sample.game;

import java.util.Vector;
import java.util.Iterator;
import java.util.Random;

// ������ �����ϴ� ���̸Ӹ� ǥ���ϴ� Ŭ����
public class Gamer {
	private int money; // ������ ��

	private Vector fruits = new Vector(); // ����

	private Random random = new Random(); // �����߻���

	private static String[] fruitsname = { // ���� �̸��� ǥ
	"���", "����", "�ٳ���", "��", };

	public Gamer(int money) { // ������
		this.money = money;
	}

	public int getMoney() { // ������ ���� ��´�.
		return money;
	}

	public void bet() { // ������ �����ų �� ȣ���ϴ� �޼ҵ�
		int dice = random.nextInt(6) + 1; // �ֻ����� ������.
		
		if (dice == 1) { // 1�� ���´�...���� �����Ѵ�.
			money += 100;
			System.out.println("���� �����߽��ϴ�.");
		} else if (dice == 2) { // 2�� ���´�...���� ������ �ش�.
			money /= 2;
			System.out.println("���� ������ �پ����ϴ�.");
		} else if (dice == 6) { // 6�� ���´�...������ �޴´�.
			String f = getFruit();
			System.out.println("����(" + f + ")�� �޾ҽ��ϴ�.");
			fruits.add(f);
		} else { // �� �ۿ�...�ƹ� �ϵ� �Ͼ�� �ʴ´�.
			System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҽ��ϴ�.");
		}
	}

	// �� �޼ҵ尡 ȣ��Ǹ�, ���� ���¸� �����ϴ� Memento ��ü�� �����ȴ�.
    // ���� ���� ���ִ� ���ϵ� ���� Memento ��ü�� �����Ѵ�.(�������� ��´�.)
	// ��Ĭ�ϰ� ������ ����� ������ ���¸� Memento �ν��Ͻ��� ������ �δ� ���̴�.
	public Memento createMemento() { 
		Memento m = new Memento(money); // ���� �����Ѵ�.
		
		// ������ �����Ѵ�.
		Iterator it = fruits.iterator();
		while (it.hasNext()) {
			String f = (String) it.next();
			if (f.startsWith("���ִ�.")) { // ������ ���ִ� �͸� ����
				m.addFruit(f);
			}
		}
		return m;
	}

	// undo�� �����Ѵ�.
	// �Է����ڷ� ���� Memento ��ü�κ��� �����Ǿ��� ���� ������ ���´�.
	public void restoreMemento(Memento memento) { 
		this.money = memento.money;
		this.fruits = memento.fruits;
	}

	public String toString() { // ���ڿ� ǥ��
		return "[money = " + money + ", fruits = " + fruits + "]";
	}

	 // ������ 1�� ��´�.
	private String getFruit() {
		String prefix = "";
		// ���������� �����ִ١��� �����̸� �տ� ���δ�.
		if (random.nextBoolean()) { 
			prefix = "���ִ�.";
		}
		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}
}
