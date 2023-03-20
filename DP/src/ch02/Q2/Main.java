package ch02.Q2;

import java.io.*;

import ch02.A2.FileProperties;

public class Main {
    public static void main(String[] args) {
        FileIO f = (FileIO) new FileProperties();
        try {
            f.readFromFile("file.txt");
            f.setValue("year", "2000");
            f.setValue("month", "11");
            f.setValue("day", "20");
            f.writeToFile("newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
