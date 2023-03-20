package ch21.A1;

public class PrinterProxy implements Printable {
    private String name;            // 이름
    private Printable real;         // "본인"에 대한 참조를 저장함              
    private String className;       // "본인"의 클래스명       
    public PrinterProxy(String name, String className) {      // 생성자   
        this.name = name;
        this.className = className;                                                 
    }
    public synchronized void setPrinterName(String name) {  // 이름의 설정
        if (real != null) { //"본인"이 이미 생성되어 있다면
            real.setPrinterName(name);  // "본인"에게도 설정한다.
        }
        this.name = name;
    }
    public String getPrinterName() {    // 이름의 취득
        return name;
    }
    public void print(String string) {  // 표시
        realize(); //이 떄, 본인이 생성된다
        real.print(string); //본인 객체의 print() 메소드를 호출 -> 위임
    }

    private synchronized void realize() {   // "본인"을 생성
        if (real == null) {
            try {                                                                       
                real = (Printable)Class.forName(className).newInstance();               
                real.setPrinterName(name);                                              
            } catch (ClassNotFoundException e) {                                        
                System.err.println("클래스 " + className + " 가 발견되지 않습니다.");      
            } catch (Exception e) {                                                     
                e.printStackTrace();                                                    
            }                                                                           
        }
    }
}
