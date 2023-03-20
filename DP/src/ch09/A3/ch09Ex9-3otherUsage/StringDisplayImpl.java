public class StringDisplayImpl extends DisplayImpl {
    private String string;                              // ǥ���ؾ��� ���ڿ�
    private int width;                                  // ����Ʈ ������ ����� ���ڿ��� "����"
    public StringDisplayImpl(String string) {           // �����ڿ��� �Ѿ�� ���ڿ� string��
        this.string = string;                               // �ʵ忡 ����� �д�
        this.width = string.getBytes().length;              // �׸��� ����Ʈ ������ ���̵� �ʵ忡 ����صΰ� ���߿� ����Ѵ�.
    }
    public void rawOpen() {
        printLine();
    }
    public void rawPrint() {
        System.out.println("|" + string + "|");         // �յڿ� "|"�� �ٿ��� ǥ��
    }
    public void rawClose() {
        printLine();
    }
    private void printLine() {
        System.out.print("+");                          // Ʋ�� �����̸� ǥ���ϴ� "+"��ũ�� ǥ���Ѵ�.
        for (int i = 0; i < width; i++) {               // width���� "-"�� ǥ���ؼ�
            System.out.print("-");                      // Ʋ�� ������ �̿��Ѵ�.
        }
        System.out.println("+");                        // Ʋ�� �����̸� ǥ���ϴ� "+"��ũ�� ǥ���Ѵ�.
    }
}
