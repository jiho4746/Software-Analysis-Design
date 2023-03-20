package hw.ch03;

// �߻� Ŭ���� AbstractDisplay
public abstract class AbstractDisplay {
	// ���� Ŭ������ ������ �ñ�� �߻�޼ҵ�(1)
	public abstract void open();

	// ���� Ŭ������ ������ �ñ�� �߻�޼ҵ�(2)
	public abstract void print();

	// ���� Ŭ������ ������ �ñ�� �߻�޼ҵ�(3)
	public abstract void close();

	// �߻� Ŭ�������� �����ϰ� �ִ� �޼ҵ� display
	// �������� �帧(�޽��� ȣ�� ����)�� �����Ѵ�.->Ʋ�� ����
	//����ȣ: print()�� timesȽ����ŭ ȣ���ϵ��� for ������ ����
	public final void display(int times) {//���� �޼ҵ�->���ø� �޼ҵ�
		// �켱 open�ϰ�...
		open();//�߻� �޼ҵ�

		// times�� print�� �ݺ��ϰ�...
		for (int i = 0; i < times; i++) {
			print();//�߻� �޼ҵ�
		}
		
		// ���������� close�Ѵ�. 
		close();
	}
}
