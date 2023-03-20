package ch21.A1;

public class PrinterProxy implements Printable {
    private String name;            // �̸�
    private Printable real;         // "����"�� ���� ������ ������              
    private String className;       // "����"�� Ŭ������       
    public PrinterProxy(String name, String className) {      // ������   
        this.name = name;
        this.className = className;                                                 
    }
    public synchronized void setPrinterName(String name) {  // �̸��� ����
        if (real != null) { //"����"�� �̹� �����Ǿ� �ִٸ�
            real.setPrinterName(name);  // "����"���Ե� �����Ѵ�.
        }
        this.name = name;
    }
    public String getPrinterName() {    // �̸��� ���
        return name;
    }
    public void print(String string) {  // ǥ��
        realize(); //�� ��, ������ �����ȴ�
        real.print(string); //���� ��ü�� print() �޼ҵ带 ȣ�� -> ����
    }

    private synchronized void realize() {   // "����"�� ����
        if (real == null) {
            try {                                                                       
                real = (Printable)Class.forName(className).newInstance();               
                real.setPrinterName(name);                                              
            } catch (ClassNotFoundException e) {                                        
                System.err.println("Ŭ���� " + className + " �� �߰ߵ��� �ʽ��ϴ�.");      
            } catch (Exception e) {                                                     
                e.printStackTrace();                                                    
            }                                                                           
        }
    }
}
