package hw.ch01;

public class BookShelfIteratorBackward implements Iterator {
		// BookShelfIterator가 검색할 책꽂이를 가리키는 속성
		private BookShelf bookShelf;
		// 현재 책 번호를 유지하는 속성
		private int index;
		
		public BookShelfIteratorBackward(BookShelf bookShelf) {
			this.bookShelf = bookShelf;
			this.index = bookShelf.getLength()-1; //박지호:책꽂이를 돌아다니기 전이므로, 마지막 위치로 초기화한다.
		}

	@Override
	public boolean hasNext() {
		//박지호:현재 책 번호가 0보다 작으면
		//책꽂이에 돌아다닐 책이 더이상 없으므로 false를 리턴한다
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
		index--; //박지호:현재 책번호를 1 감소시킨다
		return book;
	}
}
