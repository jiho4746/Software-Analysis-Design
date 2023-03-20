package ch11.Sample;

public class Main2 {

	public static void main(String[] args) {
		File f1 = new File("a.txt", 100);
		System.out.println(f1);
		
		File f2 = new File("b.txt", 200);
		System.out.println(f2);
		
		Directory d1 = new Directory("bin");
		System.out.println(d1);
		
		//p.17 ¹æ¹ý4
		//Entry d2 = new Directory("bin2");
		//(Directory)d2.add(;)
		
		d1.add(f1);
		d1.add(f2);
		
		d1.printList();
		System.out.println(d1.getSize());
		
	}

}
