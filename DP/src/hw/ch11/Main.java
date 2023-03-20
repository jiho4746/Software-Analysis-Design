package hw.ch11;

public class Main {
	public static void main(String[] args) {
		System.out.println("컴퓨터공학과 20200769 박지호");
    	System.out.println("-------------------------------------------------------------------------------");
		try {

			Directory rootdir = new Directory("MyDocuments", "20220401", "SeungHoonChoi");
			Directory bindir = new Directory("MyData", "20220401", "SeungHoonChoi");
			Directory tmpdir = new Directory("MyPictures", "20220401", "SeungHoonChoi");
					
			rootdir.add(new File("박지호0.doc", "20220501", 1000, "SeungHoonChoi"));
			rootdir.add(bindir);
			
			bindir.add(new File("박지호1.doc", "20220501", 2000, "SeungHoonChoi"));
			bindir.add(new File("박지호2.javc", "20220501", 3000, "SeungHoonChoi"));
			bindir.add(tmpdir);
			
			tmpdir.add(new File("박지호3.gif", "20220601", 4000, "SeungHoonChoi"));
			tmpdir.add(new File("박지호4.jpg", "20220601", 5000, "SeungHoonChoi"));
			tmpdir.add(new File("박지호5.pnd", "20220601", 6000, "SeungHoonChoi"));
			
			rootdir.printList();

		} catch (FileTreatmentException e) {
			e.printStackTrace();
		}
	}
}
