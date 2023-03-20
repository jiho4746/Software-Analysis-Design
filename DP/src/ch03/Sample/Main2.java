package ch03.Sample;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractDisplay x;
		
		x = new CharDisplay('A');
		x.display();
		
		x = new StringDisplay("¹ÚÁöÈ£");
		x.display();
	}

}
