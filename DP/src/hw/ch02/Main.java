package hw.ch02;

import java.io.*;

public class Main {
    public static void main(String[] args) {
    	FileIO f = new FileProperties();
    	System.out.println("컴퓨터공학과 20200769 박지호");
    	System.out.println("----------------------------------");
    	
        try {
            f.readFromFile("file.txt");
            f.setValue("Year", "2019");
            f.setValue("bornYear", "2000");
            f.setValue("StudentId", "20200769");
            f.setValue("Name", "ParkJiHo");
            f.setValue("Location", "Seoul");
            f.writeToFile("ParkJiHo.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
