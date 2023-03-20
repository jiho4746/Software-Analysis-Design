package ch14.Sample;

public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }
    
    // 해결용 메소드
    // 항상 false를 반환한다.
    protected boolean resolve(Trouble trouble) {    
        return false; // 자신은 아무 처리도 하지 않는다.
    }
}
