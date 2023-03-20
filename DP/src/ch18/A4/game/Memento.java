package ch18.A4.game;
import java.io.*;
import java.util.Vector;

// Serializable�� �����Ѵٰ� �����Ѵ�.
public class Memento implements Serializable {  
    int money;                              // ������ ��
    Vector fruits;                          // ����
    public int getMoney() {                 // ������ ���� ��´�.(narrow interface)
        return money;
    }
    Memento(int money) {                    // ������(wide interface)
        this.money = money;
        this.fruits = new Vector();
    }
    void addFruit(String fruit) {           // ������ �߰��Ѵ�.(wide interface)
        fruits.add(fruit);
    }
}
