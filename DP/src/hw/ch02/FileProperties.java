package hw.ch02;

import java.io.*;
import java.util.*;

// Properties 클래스는, 이미 존재하는 클래스이다.
// FileProperties 클래스가 어댑터 역할을 한다.
public class FileProperties extends FileIO {
	
	private Properties properties; // Properties 객체를 참조
	public FileProperties() {
        this.properties = new Properties();
    }
	
    public void readFromFile(String filename) throws IOException {
    	this.properties.load(new FileInputStream(filename));
    }
    public void writeToFile(String filename) throws IOException {
    	this.properties.store(new FileOutputStream(filename), "written by FileProperties");
    }
    public void setValue(String key, String value) {
    	this.properties.setProperty(key, value); 
    }
    public String getValue(String key) {
        return this.properties.getProperty(key, ""); 
    }
}
