package ch20.Sample;
public class Main {
	// 명령행 인자로 들어온 문자열을 실인자로 해서, 
	// BigString( ) 객체를 생성한다.
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        BigString bs = new BigString(args[0]);
        bs.print();
    }
}
