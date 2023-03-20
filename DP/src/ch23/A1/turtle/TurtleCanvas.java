package ch23.A1.turtle;

import ch23.A1.language.Executor;
import ch23.A1.language.ExecutorFactory;
import java.awt.*;


// 그림판을 제공하면서, 그림판에 그림을 그릴 Executor 객체도 생성하는 클래스
public class TurtleCanvas extends Canvas implements ExecutorFactory {
	final static int UNIT_LENGTH = 30; // 움직일 때의 길이의 단위

	final static int DIRECTION_UP = 0; // 위를 향한다.

	final static int DIRECTION_RIGHT = 3; // 우향

	final static int DIRECTION_DOWN = 6; // 아래를 향한다.

	final static int DIRECTION_LEFT = 9; // 좌향

	final static int RELATIVE_DIRECTION_RIGHT = 3; // 우향후인 경우 3을 더한다.

	final static int RELATIVE_DIRECTION_LEFT = -3; // 좌향좌인 경우 3을 뺀다.

	final static int RADIUS = 3; // 반경

	private int direction = 0; // 0, 3, 6, 9 중 하나의 값을 가진다.

	private Point position;

	public TurtleCanvas(int width, int height) {
		setSize(width, height);
		initialize();
	}

	// 현재 방향에서 좌향좌 또는 우향우를 시키는 메소드
	void setRelativeDirection(int relativeDirection) {
		setDirection(direction + relativeDirection);
		// 예1: 현재 방향이 0인데, relativeDirection이 -3이면 실인자값이 -3(음수)가 된다. => 9로 바꾸어야
		// 한다.
		// 예2: 현재 방향이 9인데, , relativeDirection이 +3이면 실인자값이 12가 된다. => 0으로 바꾸어야
		// 한다.
	}

	void setDirection(int direction) {
		// 뱡향을 나타내는 값이 음수인 경우, (예: -3)
		if (direction < 0) {
			direction = 12 - (-direction) % 12; // direction이 음수인 경우, 양수로 만든다.
												// (예1: 12-(+3)%12 => 9가 된다)
		} else {
			direction = direction % 12; // direction이 12인 경우에 0으로 만든다.
		}
		this.direction = direction % 12;
	}

	// 현재 방향에 따라 x나 y 좌표 값을 새로 설정한 후, 
	// 현재 위치(position.x, position.y)에서 새로운 위치(newx, newy) 까지 직선을 그리는 함수 
	void go(int length) {
		// 현재 이동 방향에 따른 새로운 위치 구함
		int newx = position.x;
		int newy = position.y;
		switch (direction) {
		case DIRECTION_UP:
			newy -= length; // 위로 가려면, y 좌표를 줄인다.
			break;
		case DIRECTION_RIGHT:
			newx += length; // 현재 방향이 우향이면, x 좌표를 증가시킨다.
			break;
		case DIRECTION_DOWN:
			newy += length; // 현재 방향이 아래로이면, y 좌표를 증가시킨다.
			break;
		case DIRECTION_LEFT:
			newx -= length;
			break;
		default:
			break;
		}
		
		// 현재 위치에서 새로운 위치로 직선을 그림
		Graphics g = getGraphics();
		if (g != null) {
			g.drawLine(position.x, position.y, newx, newy); // 선을 긋고
			g.fillOval(newx - RADIUS, newy - RADIUS, RADIUS * 2 + 1,
					RADIUS * 2 + 1); // 선 끝점에 작은 원(점) 을 그린다.
		}
		position.x = newx;
		position.y = newy;
	}

	// canvas에 그림을 그리는 일을 하는 Executor 객체를 생성함
	public Executor createExecutor(String name) {
		if (name.equals("go")) {
			return new GoExecutor(this);
		} else if (name.equals("right")) {
			// 우향우일 때는 +3 전달
			return new DirectionExecutor(this, RELATIVE_DIRECTION_RIGHT);
		} else if (name.equals("left")) {
			// 좌향좌일 때는 -3 전달
			return new DirectionExecutor(this, RELATIVE_DIRECTION_LEFT);
		} else {
			return null;
		}
	}

	// canvas를 초기화하는 메소드
	public void initialize() {
		Dimension size = getSize();
		position = new Point(size.width / 2, size.height / 2); // 차의 시작 위치
		direction = 0;
		setForeground(Color.red);
		setBackground(Color.white);
		Graphics g = getGraphics();
		if (g != null) {
			g.clearRect(0, 0, size.width, size.height);
		}
	}
}

// Executor들의 상위 클래스
abstract class TurtleExecutor implements Executor {
	protected TurtleCanvas canvas;

	public TurtleExecutor(TurtleCanvas canvas) {
		this.canvas = canvas;
	}

	public abstract void execute();
}

// 차를 현재 방향으로 일정한 크기만큼 움직이는 executor
class GoExecutor extends TurtleExecutor {
	public GoExecutor(TurtleCanvas canvas) {
		super(canvas);
	}

	public void execute() {
		canvas.go(TurtleCanvas.UNIT_LENGTH);
	}
}

// 좌회전, 우회전 방향을 바꾸어주는 executor
class DirectionExecutor extends TurtleExecutor {
	private int relativeDirection;

	public DirectionExecutor(TurtleCanvas canvas, int relativeDirection) {
		super(canvas);
		this.relativeDirection = relativeDirection;
	}

	// execute( ) 이 호출될 때마다 +3 또는 -3이 canvas에 전달됨
	public void execute() {
		canvas.setRelativeDirection(relativeDirection);
	}
}
