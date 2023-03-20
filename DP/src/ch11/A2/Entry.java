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
        StringBuffer fullname = new StringBuffer(); //String�� ���� �� ����ؼ� �߰��ϸ鼭 ����
        Entry entry = this;
        do {
            fullname.insert(0, "/" + entry.getName()); //0(�� ��)�� �߰� + �ڱ� �̸�
            entry = entry.parent; //entry�� �θ��
        } while (entry != null);
        return fullname.toString(); //String������ String���� �ٲ�
    }
}
