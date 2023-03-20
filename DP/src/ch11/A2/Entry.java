package ch11.A2;

public abstract class Entry {
    protected Entry parent; 
    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    public void printList() {
        printList("");
    }
    protected abstract void printList(String prefix);
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
    public String getFullName() {                 
        StringBuffer fullname = new StringBuffer(); //String을 만들 때 계속해서 추가하면서 만듦
        Entry entry = this;
        do {
            fullname.insert(0, "/" + entry.getName()); //0(맨 앞)에 추가 + 자기 이름
            entry = entry.parent; //entry의 부모로
        } while (entry != null);
        return fullname.toString(); //String내용이 String으로 바뀜
    }
}
