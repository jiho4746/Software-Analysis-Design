package hw.ch04.tv;

import hw.ch04.*;
import java.util.*;

import ch04.Sample.idcard.IDCard;

public class TVFactory extends Factory {
	//생성된 제품들의 "모델번호"들을 저장하는 변수
	private Vector<String> modelsNos = new Vector<String>();
    
    protected Product createProduct(String model) {
        return new TV_ParkJiHo(model);
    }
    protected void registerProduct(Product product) {
    	modelsNos.add(((TV_ParkJiHo)product).getmodelNo());
    }
    //modelsNos에 저장되어 있는 모델 번호들을 하나씩 끄집어내 와서 출력(수정 전)
    public void printAllModelNumbers() {
    	Iterator<String> i  = modelsNos.iterator(); 
    	
    	while(i.hasNext()) {
        	System.out.println(i.next());
        }
    }
}
