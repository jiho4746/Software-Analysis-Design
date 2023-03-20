package hw.ch10;

public class Student implements Comparable<Student> {
	private String name;
	private String id;
	private int height;
	
	public Student(String string, String string2, int i) {
		name = string;
		id = string2;
		height = i;
	}
	@Override
	public int compareTo(Student s) {
		if(this.height>s.height) {return 1;}
		else if(this.height==s.height){return 0;}
		else {return -1;}
	}
	public String toString() {
		return "[�̸�: " + name +", �й�: "+ id +", Ű: "+ height + "]";
	}
	//�Ӽ��� private���� �����Ƿ� getter �߰�
	public String getNmae() {return name;}
	public String getId() {return id;}
	public int getHeight() {return height;}
}
