package ch15.Sample.pagemaker;

import java.io.Writer;
import java.io.IOException;

public class HtmlWriter {
	// Writer 클래스: Abstract class for writing to character streams.
    private Writer writer;
    public HtmlWriter(Writer writer) {  // 생성자
        this.writer = writer;
    }
    // title을 포함한 html 문서의 앞 부분을 출력하는 메소드
    public void title(String title) throws IOException { 
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>\n");
    }
    // 단락을 출력하는 메소드
    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>\n");
    }
    // 하이퍼링크를 출력하는 메소드
    public void link(String href, String caption) throws IOException { 
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
        // <a href = "www.duksung.ac.kr" >덕성여대</a>
    }
    // 메일주소를 출력하는 메소드
    public void mailto(String mailaddr, String username) throws IOException {   // 
        link("mailto:" + mailaddr, username);
    }
    // html의 마지막 부분을 출력하는 메소드
    public void close() throws IOException { 
        writer.write("</body>");
        writer.write("</html>\n");
        writer.close();
    }
}
