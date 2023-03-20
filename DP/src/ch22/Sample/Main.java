package ch22.Sample;

import ch22.Sample.command.*;
import ch22.Sample.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 예제 프로그램을 작동시키는 클래스
public class Main extends JFrame implements ActionListener,
		MouseMotionListener, WindowListener {
	/*
	 * MouseMotionListener : 마우스를 클릭하고 드래그, 마우스를 클릭하지 않고 드래그 (2가지 처리)
	 */

	// DrawCanvas 생성 시에 인자로 넘겨줌
	// Main 인스턴스와 DrawCanvas 인스턴스가 history를 공유한다.
	private MacroCommand history = new MacroCommand();

	// 그림 그리는 영역을 나타냄
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);

	// javax.swing.JButton 클래스
	// 그린 점들을 모두 지우는 버튼
	private JButton clearButton = new JButton("clear");

	public Main(String title) {
		super(title);
		// 리스너 등록하기
		this.addWindowListener(this);
		canvas.addMouseMotionListener(this);
		// 익명 내부클래스 - 추가 코드
		/*
		 canvas.addMouseMotionListener(new MouseMotionAdapter(){
		 	public void mouseDragged(MouseEvent e){
		 		Command cmd = new DrawCommand(canvas, e.getPoint());  
				history.append(cmd); 
				cmd.execute(); 
		 	}
		 });
		 */
		clearButton.addActionListener(this);

		// 여러 가지 GUI 부품을 배치함
		// Box 객체를 이용함
		// Box: BoxLayout 객체를 레이아웃매니저로 사용하는 가벼운 컨테이너
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);

		// 프레임을 화면에 보여준다.
		pack();
		setVisible(true);
	}

	// clearButton이 눌러졌을 때 호출되는 메소드
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clearButton) {
			history.clear(); // history에 보관되어 있던 모든 명령을 지우고
			canvas.repaint(); // 캔버스의 repaint( )가 호출된다.
		}
	}

	// MouseMotionListener (1)
	public void mouseMoved(MouseEvent e) {
		//빈칸으로 구현했음.
	}
	// MouseMotionListener (2)
	// 사용자가 마우스를 drag 하면 이 메소드가 호출된다.
	// Drag할 때마다 계속 호출되고 DrawCommand 만들어짐 -> History 스택에 쌓임
	public void mouseDragged(MouseEvent e) {
		// 그리기 명령을 나타내는 DrawCommand 객체를 생성한 후,
		Command cmd = new DrawCommand(canvas, e.getPoint());  // e.getPoint( ) : 마우스 이벤트가 발생한 위치를 얻음
		history.append(cmd); // 이를 history에 추가하고,
		cmd.execute(); // 지정 위치에 빨간 점을 그린다.
	}

	// WindowListener
	
	// 창의 오른 쪽 위 아이콘 중에  X 사각형을 눌렀을 때 호출되는 메소드
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	// WindowListener 인터페이스에 선언되어 있는 나머지 메소드들
	// 구현할 필요가 없으므로, 빈 문장의 메소드로 구현되어 있다.
	public void windowActivated(WindowEvent e) {
		// X를 누르면 창이 닫힘
		// System.exit(0);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public static void main(String[] args) {
		new Main("Command Pattern Sample");
	}
}
