package hw.ch01;

public class BookShelfIteratorBackward implements Iterator {
		// BookShelfIterator�� �˻��� å���̸� ����Ű�� �Ӽ�
		private BookShelf bookShelf;
		// ���� å ��ȣ�� �����ϴ� �Ӽ�
		private int index;
		
		public BookShelfIteratorBackward(BookShelf bookShelf) {
			this.bookShelf = bookShelf;
			this.index = bookShelf.getLength()-1; //����ȣ:å���̸� ���ƴٴϱ� ���̹Ƿ�, ������ ��ġ�� �ʱ�ȭ�Ѵ�.
		}

	@Override
	public boolean hasNext() {
		//����ȣ:���� å ��ȣ�� 0���� ������
		//å���̿� ���ƴٴ� å�� ���̻� �����Ƿ� false�� �����Ѵ�
		if (index >= 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Object next() {
		Book book = bookShelf.getBookAt(index);
		index--; //����ȣ:���� å��ȣ�� 1 ���ҽ�Ų��
		return book;
	}
}
