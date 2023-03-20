package ch15.Sample.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// Database 클래스와 HtmlWriter 클래스를 조합하여, 
// 지정된 사용자의 웹 페이지를 작성하기 위한 클래스
public class PageMaker {

	private PageMaker() { // 인스턴스는 만들기 않기 때문에 private선언한다.
	}

	// HtmlWriter 클래스의 메소드들을 이용해서
	// 입력 인자로 들어온 filename 파일에 HTML 문서를 작성한다.
	// 정적 메소드이다.
	public static void makeWelcomePage(String mailaddr, String filename) {
		try {
			// "maildata.txt" 라는 프로퍼티 파일로부터 속성들을 읽어들인다.
			Properties mailprop = Database.getProperties("maildata");

			// mailaddr 변수에는 "a1@youngjin.com"이 들어있으므로,
			// "maildata.txt" 파일에서 "a1@youngjin.com" 속성의 값을 얻어와서 username에 저장한다.
			String username = mailprop.getProperty(mailaddr);

			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));

			// 제약조건: title( )메소드가 제일 먼저 호출되어야 한다.
			// 이 조건은, 창구가 되는 PageMaker 클래스에 표현되어 있다.
			writer.title("Welcome to " + username + "'s page!");
			writer.paragraph(username + "의 페이지에 오신걸 환영합니다.");
			writer.paragraph("메일이 기다리고 있습니다.");
			writer.mailto(mailaddr, username);
			writer.close();
			
			System.out.println(filename + " is created for " + mailaddr + " ("
					+ username + ")");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
