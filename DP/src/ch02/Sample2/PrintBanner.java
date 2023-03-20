package ch02.Sample2;

//어댑터 역할을 하는 클래스
public class PrintBanner extends Print {
    private Banner banner; // Banner 객체를 참조
    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }
    public void printWeak() {
		// Banner 객체인 banner의 showWithParen( )을 호출한다.
		// printWeak( )는 자신이 일을 처리하지 않고 banner에게 위임한다.
        banner.showWithParen();
    }

    public void printStrong() {
	    // banner의 showWithAster()을 호출한다.
        // PrintBanner 자신이 일을 처리하지 않고, banner에게 위임한다.
		banner.showWithAster();
    }
}
