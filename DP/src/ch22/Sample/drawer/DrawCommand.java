package ch22.Sample.drawer;

import ch22.Sample.command.Command;
import java.awt.Point;

// ‘그림 그리기 명령’을 표현함
public class DrawCommand implements Command {
	// 그림 그리기를 실행할 대상(객체)를 저장함
	protected Drawable drawable;

	// 그림 그리는 위치
	private Point position;
	// java.awt.Point 클래스: X좌표와 Y좌표를 갖는 클래스
	// 2차원 평면 상의 위치를 나타냄
	// 속성으로 x, y를 가진다.

	// 생성자
	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position = position;
	}

	// 실제 그리기를 실행하는 메소드
	// drawable 필드의 draw 메소드를 호출함
	public void execute() {
		drawable.draw(position.x, position.y);
	}
}
