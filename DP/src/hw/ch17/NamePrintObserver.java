package hw.ch17;

public class NamePrintObserver implements Observer{
	 public void update(NumberGenerator generator) {
	        System.out.print("Console 출력:");
	        // 관찰대상자로부터 숫자를 얻어 그 숫자만큼의 자기 이름을 새로운 한 줄에 계속해서 출력
	        int count = generator.getNumber();
	        for (int i = 0; i < count; i++) {
	            System.out.print("박지호"); 
	        }
	        System.out.println("");
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	        }
	    }
}
