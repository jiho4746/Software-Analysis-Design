package ch23.Sample;

// 구문 해석 중에 발생한 예외를 위한 클래스
public class ParseException extends Exception {
    public ParseException(String msg) {
        super(msg);
    }
}
