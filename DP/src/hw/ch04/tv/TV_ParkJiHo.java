package hw.ch04.tv;

import hw.ch04.*;

public class TV_ParkJiHo extends Product {
    private String modelNo;
   
    TV_ParkJiHo(String modelNo) {
        this.modelNo = modelNo;
    }
    public void use() {
    	System.out.println("�𵨹�ȣ�� "+ modelNo +  "�� TV�� ����մϴ�.");
    }
    public String getmodelNo() {
        return modelNo;
    }
}
