package ch07.A3;

public class Director {
    private Builder builder;
    public Director(Builder builder) {      // Builder�� ���� Ŭ������ �ν��Ͻ��� �����Ǳ� ������
        this.builder = builder;             // builder �ʵ忡 ������ �д�.
    }
    public Object construct() {             // ���� ����
        builder.makeTitle("Greeting");              // Ÿ��Ʋ
        builder.makeString("��ħ�� ����");     // ���ڿ�
        builder.makeItems(new String[]{             // �׸�
            "���� ��ħ�Դϴ�.",
            "�ȳ��ϼ���",
        });
        builder.makeString("�㿡");                 // �ٸ� ���ڿ�
        builder.makeItems(new String[]{             // �ٸ� �׸�
            "�ȳ��ϼ���",
            "�ȳ��� �ֹ�����",
            "�ȳ��� �輼��",
        });
        return builder.getResult();                 // �ϼ��� ������ ��ȯ ���� �ȴ�.
    }
}
