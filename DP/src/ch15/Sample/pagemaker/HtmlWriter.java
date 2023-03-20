package ch15.Sample.pagemaker;

import java.io.Writer;
import java.io.IOException;

public class HtmlWriter {
	// Writer Ŭ����: Abstract class for writing to character streams.
    private Writer writer;
    public HtmlWriter(Writer writer) {  // ������
        this.writer = writer;
    }
    // title�� ������ html ������ �� �κ��� ����ϴ� �޼ҵ�
    public void title(String title) throws IOException { 
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>\n");
    }
    // �ܶ��� ����ϴ� �޼ҵ�
    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>\n");
    }
    // �����۸�ũ�� ����ϴ� �޼ҵ�
    public void link(String href, String caption) throws IOException { 
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
        // <a href = "www.duksung.ac.kr" >��������</a>
    }
    // �����ּҸ� ����ϴ� �޼ҵ�
    public void mailto(String mailaddr, String username) throws IOException {   // 
        link("mailto:" + mailaddr, username);
    }
    // html�� ������ �κ��� ����ϴ� �޼ҵ�
    public void close() throws IOException { 
        writer.write("</body>");
        writer.write("</html>\n");
        writer.close();
    }
}
