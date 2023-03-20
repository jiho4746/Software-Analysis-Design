package ch22.Sample;

import ch22.Sample.command.*;
import ch22.Sample.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// ���� ���α׷��� �۵���Ű�� Ŭ����
public class Main extends JFrame implements ActionListener,
		MouseMotionListener, WindowListener {
	/*
	 * MouseMotionListener : ���콺�� Ŭ���ϰ� �巡��, ���콺�� Ŭ������ �ʰ� �巡�� (2���� ó��)
	 */

	// DrawCanvas ���� �ÿ� ���ڷ� �Ѱ���
	// Main �ν��Ͻ��� DrawCanvas �ν��Ͻ��� history�� �����Ѵ�.
	private MacroCommand history = new MacroCommand();

	// �׸� �׸��� ������ ��Ÿ��
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);

	// javax.swing.JButton Ŭ����
	// �׸� ������ ��� ����� ��ư
	private JButton clearButton = new JButton("clear");

	public Main(String title) {
		super(title);
		// ������ ����ϱ�
		this.addWindowListener(this);
		canvas.addMouseMotionListener(this);
		// �͸� ����Ŭ���� - �߰� �ڵ�
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

		// ���� ���� GUI ��ǰ�� ��ġ��
		// Box ��ü�� �̿���
		// Box: BoxLayout ��ü�� ���̾ƿ��Ŵ����� ����ϴ� ������ �����̳�
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);

		// �������� ȭ�鿡 �����ش�.
		pack();
		setVisible(true);
	}

	// clearButton�� �������� �� ȣ��Ǵ� �޼ҵ�
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clearButton) {
			history.clear(); // history�� �����Ǿ� �ִ� ��� ����� �����
			canvas.repaint(); // ĵ������ repaint( )�� ȣ��ȴ�.
		}
	}

	// MouseMotionListener (1)
	public void mouseMoved(MouseEvent e) {
		//��ĭ���� ��������.
	}
	// MouseMotionListener (2)
	// ����ڰ� ���콺�� drag �ϸ� �� �޼ҵ尡 ȣ��ȴ�.
	// Drag�� ������ ��� ȣ��ǰ� DrawCommand ������� -> History ���ÿ� ����
	public void mouseDragged(MouseEvent e) {
		// �׸��� ����� ��Ÿ���� DrawCommand ��ü�� ������ ��,
		Command cmd = new DrawCommand(canvas, e.getPoint());  // e.getPoint( ) : ���콺 �̺�Ʈ�� �߻��� ��ġ�� ����
		history.append(cmd); // �̸� history�� �߰��ϰ�,
		cmd.execute(); // ���� ��ġ�� ���� ���� �׸���.
	}

	// WindowListener
	
	// â�� ���� �� �� ������ �߿�  X �簢���� ������ �� ȣ��Ǵ� �޼ҵ�
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	// WindowListener �������̽��� ����Ǿ� �ִ� ������ �޼ҵ��
	// ������ �ʿ䰡 �����Ƿ�, �� ������ �޼ҵ�� �����Ǿ� �ִ�.
	public void windowActivated(WindowEvent e) {
		// X�� ������ â�� ����
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
