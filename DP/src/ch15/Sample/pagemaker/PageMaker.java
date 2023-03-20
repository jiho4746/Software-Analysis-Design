package ch15.Sample.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// Database Ŭ������ HtmlWriter Ŭ������ �����Ͽ�, 
// ������ ������� �� �������� �ۼ��ϱ� ���� Ŭ����
public class PageMaker {

	private PageMaker() { // �ν��Ͻ��� ����� �ʱ� ������ private�����Ѵ�.
	}

	// HtmlWriter Ŭ������ �޼ҵ���� �̿��ؼ�
	// �Է� ���ڷ� ���� filename ���Ͽ� HTML ������ �ۼ��Ѵ�.
	// ���� �޼ҵ��̴�.
	public static void makeWelcomePage(String mailaddr, String filename) {
		try {
			// "maildata.txt" ��� ������Ƽ ���Ϸκ��� �Ӽ����� �о���δ�.
			Properties mailprop = Database.getProperties("maildata");

			// mailaddr �������� "a1@youngjin.com"�� ��������Ƿ�,
			// "maildata.txt" ���Ͽ��� "a1@youngjin.com" �Ӽ��� ���� ���ͼ� username�� �����Ѵ�.
			String username = mailprop.getProperty(mailaddr);

			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));

			// ��������: title( )�޼ҵ尡 ���� ���� ȣ��Ǿ�� �Ѵ�.
			// �� ������, â���� �Ǵ� PageMaker Ŭ������ ǥ���Ǿ� �ִ�.
			writer.title("Welcome to " + username + "'s page!");
			writer.paragraph(username + "�� �������� ���Ű� ȯ���մϴ�.");
			writer.paragraph("������ ��ٸ��� �ֽ��ϴ�.");
			writer.mailto(mailaddr, username);
			writer.close();
			
			System.out.println(filename + " is created for " + mailaddr + " ("
					+ username + ")");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
