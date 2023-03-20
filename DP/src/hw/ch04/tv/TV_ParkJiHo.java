package hw.ch04.tv;

import hw.ch04.*;

public class TV_ParkJiHo extends Product {
    private String modelNo;
   
    TV_ParkJiHo(String modelNo) {
        this.modelNo = modelNo;
    }
    public void use() {
    	System.out.println("모델번호를 "+ modelNo +  "인 TV를 사용합니다.");
    }
    public String getmodelNo() {
        return modelNo;
    }
}
