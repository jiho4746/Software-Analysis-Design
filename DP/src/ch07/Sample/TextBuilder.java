package ch07.Sample;

public class TextBuilder extends Builder {
// �������̽��� ����
// public class TextBuilder implements Builder {
    private StringBuffer buffer = new StringBuffer();           // �� �ʵ忡 ������ �����Ѵ�.
    public void makeTitle(String title) {                       // �Ϲ� �ؽ�Ʈ������ Ÿ��Ʋ
        buffer.append("==============================\n");          // ��ļ�
        buffer.append("��" + title + "��\n");                       // ������ ���� Ÿ��Ʋ
        buffer.append("\n");                                        // ����
    }
    public void makeString(String str) {                        // �Ϲ� �ؽ�Ʈ������ ���ڿ�
        buffer.append('��' + str + "\n");                           // ���� ���� ���ڿ�
        buffer.append("\n");                                        // ����
    }
    public void makeItems(String[] items) {                     // �Ϲ� �ؽ�Ʈ������ �׸�
        for (int i = 0; i < items.length; i++) {
            buffer.append("��" + items[i] + "\n");                // ���� ���� �׸�
        }
        buffer.append("\n");                                        // ����
    }
    public Object getResult() {                                 // �ϼ��� ����
        buffer.append("==============================\n");          // ��ļ�
        return buffer.toString();                                   // StringBuffer��String�� ��ȯ
    }
}
