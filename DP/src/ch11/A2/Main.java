package ch11.A2;
//부모를 알아야 경로를 알 수 있음 -> 관리

public class Main {
    public static void main(String[] args) {
        try {
            Directory rootdir = new Directory("root");

            Directory usrdir = new Directory("usr");
            rootdir.add(usrdir);

            Directory Kim = new Directory("Kim");
            usrdir.add(Kim);

            File file = new File("Composite.java", 100);
            Kim.add(file);
            rootdir.printList();

            System.out.println("");
            System.out.println("file = " + file.getFullName());     
            System.out.println("Kim = " + Kim.getFullName());     
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
