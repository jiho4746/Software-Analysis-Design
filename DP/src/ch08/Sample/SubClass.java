package ch08.Sample;

class SuperClass {
  
  private int priv1 = 10;
  protected int prot1 = 11;
  public int publ1 = 12;

 SuperClass( ) {
    priv1 = 999;
  }
  SuperClass(int a) {
    priv1 = a;
  }
  public int getPriv1( ) {
	  return priv1;
  }
}

public class SubClass extends SuperClass {
  //int priv1 = 110;
  //int prot1 = 111;
  //int publ1= 112;

  public static void main(String args[]) {
    SubClass sub = new SubClass( );	 
    System.out.println("priv1 = " + sub.getPriv1( ) );
	System.out.println("prot1 = " + sub.prot1);
	System.out.println("publ1 = " + sub.publ1);
  }
}