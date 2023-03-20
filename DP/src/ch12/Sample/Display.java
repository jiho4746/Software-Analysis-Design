package ch12.Sample;

// 여러 줄로 이루어진 문자열을 표시하기 위한 추상 클래스
public abstract class Display {
	//[크기를 알기 위한 함수]
	public abstract int getColumns(); // 가로의 문자수를 얻는다.
	public abstract int getRows(); // 세로의 줄수를 얻는다.

	public abstract String getRowText(int row); // row번째의 문자열을 얻는다.

	//모든 줄을 화면에 표시하는 메소드
	// Template Method 패턴이 적용됨
	// 템플릿 메소드: 추상 메소드들을 호출하는 문장들로 이루어진 메소드
	public final void show() { 
		for (int i = 0; i < getRows(); i++) {
			System.out.println(getRowText(i));
		}
	}
}
