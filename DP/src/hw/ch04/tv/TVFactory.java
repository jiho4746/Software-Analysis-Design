package hw.ch04.tv;

import hw.ch04.*;
import java.util.*;

import ch04.Sample.idcard.IDCard;

public class TVFactory extends Factory {
	//������ ��ǰ���� "�𵨹�ȣ"���� �����ϴ� ����
	private Vector<String> modelsNos = new Vector<String>();
    
    protected Product createProduct(String model) {
        return new TV_ParkJiHo(model);
    }
    protected void registerProduct(Product product) {
    	modelsNos.add(((TV_ParkJiHo)product).getmodelNo());
    }
    //modelsNos�� ����Ǿ� �ִ� �� ��ȣ���� �ϳ��� ����� �ͼ� ���(���� ��)
    public void printAllModelNumbers() {
    	Iterator<String> i  = modelsNos.iterator(); 
    	
    	while(i.hasNext()) {
        	System.out.println(i.next());
        }
    }
}
