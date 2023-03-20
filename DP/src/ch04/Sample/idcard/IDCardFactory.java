package ch04.Sample.idcard;

import ch04.Sample.framework.*;
import java.util.*;

public class IDCardFactory extends Factory {
	// Vector는 배열과 비슷하지만 전체 크기가 정해져 있지 않고
	// 원소를 추가하면 필요한 경우 크기가 늘어난다.
    private Vector owners = new Vector();

	// 이 공장의 제품인 IDCard를 생산한다.
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

	// 생산된 제품의 owner를 등록(추가)한다.
    protected void registerProduct(Product product) {
        // product 를 IDCard로 형변환해야, getOwner()를 호출할 수 있다.
		owners.add(((IDCard)product).getOwner());
    }
    public Vector getOwners() {
        return owners;
    }
}
