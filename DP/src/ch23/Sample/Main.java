package ch23.Sample;

import java.util.*;
import java.io.*;

// 미니언어의 인터프리터를 작동시키기 위한 클래스
public class Main {
	public static void main(String[] args) {
		try {
			// program.txt 파일의 내용을 
			BufferedReader reader = new BufferedReader(new FileReader(
					"program.txt"));
			String text;
			// 한 줄씩 읽어서 구문 해석을 시킨다.
			while ((text = reader.readLine()) != null) {
				System.out.println("text = \"" + text + "\"");
				// ProgramNode를 만든다.
				Node node = new ProgramNode();
				// text를 인자로해서 Context 객체를 만든 후, 파싱을 시도한다.
				node.parse(new Context(text));
				// ProgramNode의 toString( ) 이 호출된다.
				System.out.println("node = " + node);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
