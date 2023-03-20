0package ch04.Sample.framework;

public abstract class Factory {
	// ���� �����, ����ϴ� ���� �ϴ� �޼ҵ� (���ø��޼ҵ��̴�)
    public final Product create(String owner) {//���� �޼ҵ�->���ø� �޼ҵ�
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

	//(1) ���� Ŭ����(��ü���� ����)���� �����ϴ� �޼ҵ��
    protected abstract Product createProduct(String owner); 
    /*(3) ������ ó�� -> ���� Ŭ����(FactoryMethodRuntimeException) �����ؾ� ��
    protected Product createProduct(String owner) throws FactoryMethodRuntimeException {
    	throw new FactoryMethodRuntimeException();
    }
    */
    protected abstract void registerProduct(Product product);
}
