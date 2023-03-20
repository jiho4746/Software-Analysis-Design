package ch15.Sample;

import ch15.Sample.pagemaker.PageMaker;

// pagemaker 패키지의 PageMaker 클래스를 이용해서, 
// a1@yonugin.com를 key로 한 value(사용자 이름)를 가지고 
// “welcom.html” 이라는 HTML 문서를 완성한다.
public class Main {
	public static void main(String[] args) {
		// Main의 main( ) 메소드는, Database나 HtmlWriter의 메소드를 직접사용하지 않고,
		// facade역할(high-level API를 제공하는)을 하는 
		// PageMaker의 makeWelcomPage( ) 메소드만을 사용해서
		// 원하는 일을 수행한다.
		PageMaker.makeWelcomePage("a1@youngjin.com", "welcome.html");
		PageMaker.makeWelcomePage("csh@duksung.ac.kr", "welcome2.html");
		
	}
}
