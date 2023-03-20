package hw.ch11;

public class File extends Entry {
	private String name;
	private String date;
	private int size;
	private String author;
	//메소드 추가 -> 변수도 추가
	public File(String name, String date, int size, String author) {
		this.name = name;
		this.date = date;
		this.size = size;
		this.author =author;
	}
	public int getCount() {
		return 1;
	}
	
	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);
	}
	@Override
	public String getDate() {
		return date;
	}
	@Override
	public String getAuthor() {
		return author;
	}
}
