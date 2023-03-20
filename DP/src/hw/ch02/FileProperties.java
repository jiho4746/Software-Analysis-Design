package hw.ch02;

import java.io.*;
import java.util.*;

// Properties Ŭ������, �̹� �����ϴ� Ŭ�����̴�.
// FileProperties Ŭ������ ����� ������ �Ѵ�.
public class FileProperties extends FileIO {
	
	private Properties properties; // Properties ��ü�� ����
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
