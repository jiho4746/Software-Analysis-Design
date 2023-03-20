package hw.ch02;

import java.io.*;


// Main(client)가 필요로하는 메소드
public abstract class FileIO {
    public abstract void readFromFile(String filename) throws IOException;
    public abstract void writeToFile(String filename) throws IOException;
    public abstract void setValue(String key, String value);
    public abstract String getValue(String key);
}
