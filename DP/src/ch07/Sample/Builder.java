package ch07.Sample;

public abstract class Builder {
// 인터페이스로 변경
// public interface Builder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract Object getResult();
}
