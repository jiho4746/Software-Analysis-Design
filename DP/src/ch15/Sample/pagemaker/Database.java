package ch15.Sample.pagemaker;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database { //속성 파일을 읽어서 리턴해줌
	// 다른 클래스에서 이 클래스의 인스턴스를 new를 이용해 생성시키지 않게 하기 위해 
	// private으로 선언함.
	private Database() {
	}

	// Properties 인스턴스를 생성한 후,
	// (dbname).txt 파일로부터 여러 가지 속성 값을 읽어 들여 이를 리턴하는 메소드
	public static Properties getProperties(String dbname) { //생성자를 못 만들지만 static으로 선언해서 접근 가능
		String filename = dbname + ".txt";
		// Properties 클래스는,
		// key(프로퍼티 이름)와 value(프로퍼티의 값) 쌍으로 되어 있는 속성의 집합을 유지하는 클래스
		Properties prop = new Properties();
		try {
			//FileInputStream 클래스: obtains input bytes from a file in a file system.
			prop.load(new FileInputStream(filename)); //1바이트씩 읽어들임
		} catch (IOException e) {
			System.out.println("Warning: " + filename + " is not found.");
		}
		return prop;
	}
}
// (dbname).txt 파일은,
// 속성들을 저장하고 있는 파일
// 형식: key=value

