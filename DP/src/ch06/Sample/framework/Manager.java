package ch06.Sample.framework;
import java.util.*;

public class Manager {
    private Hashtable showcase = new Hashtable();
    public void register(String name, Product proto) {
        showcase.put(name, proto); //key-value
    }
    public Product create(String protoname) {
        Product p = (Product)showcase.get(protoname); // key
        return p.createClone(); //복제 실행
    }
}
