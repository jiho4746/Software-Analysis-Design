package ch15.Sample;

import ch15.Sample.pagemaker.PageMaker;

// pagemaker ��Ű���� PageMaker Ŭ������ �̿��ؼ�, 
// a1@yonugin.com�� key�� �� value(����� �̸�)�� ������ 
// ��welcom.html�� �̶�� HTML ������ �ϼ��Ѵ�.
public class Main {
	public static void main(String[] args) {
		// Main�� main( ) �޼ҵ��, Database�� HtmlWriter�� �޼ҵ带 ����������� �ʰ�,
		// facade����(high-level API�� �����ϴ�)�� �ϴ� 
		// PageMaker�� makeWelcomPage( ) �޼ҵ常�� ����ؼ�
		// ���ϴ� ���� �����Ѵ�.
		PageMaker.makeWelcomePage("a1@youngjin.com", "welcome.html");
		PageMaker.makeWelcomePage("csh@duksung.ac.kr", "welcome2.html");
		
	}
}
