package ch07.A2;

import java.io.*;

public class HTMLBuilder extends Builder {
    private String filename;                                    // �ۼ��� ���ϸ�
    private PrintWriter writer;                                 // ���Ͽ� ����� PrintWriter
    public void buildTitle(String title) {                       // HTML ���Ͽ����� Ÿ��Ʋ
        filename = title + ".html";                                 // Ÿ��Ʋ�� ���� ���ϸ��� ����
        try {
            writer = new PrintWriter(new FileWriter(filename));     // PrintWriter�����.
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");    // Ÿ��Ʋ�� ���
        writer.println("<h1>" + title + "</h1>");
    }
    public void buildString(String str) {                        // HTML ���Ͽ����� ���ڿ�
        writer.println("<p>" + str + "</p>");                       // <p>�±׿��� ���
    }
    public void buildItems(String[] items) {                     // HTML ���Ͽ����� �׸�
        writer.println("<ul>");                                     // <ul>��<li>���� ���
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>" + items[i] + "</li>");
        }
        writer.println("</ul>");
    }
    public Object buildResult() {                                 // �ϼ��� ����
        writer.println("</body></html>");                           // �±׸� �����.
        writer.close();                                             // ������ Ŭ����
        return filename;                                            // ���ϸ��� ��ȯ�Ѵ�.
    }
 }
