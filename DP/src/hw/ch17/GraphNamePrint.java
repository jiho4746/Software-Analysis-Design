package hw.ch17;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class GraphNamePrint extends Frame implements Observer, ActionListener{
	private GraphText textGraph = new GraphText(60);
	private GraphText textGraph2 = new GraphText(60);
	private GraphCanvas canvasGraph = new GraphCanvas();

	private Button buttonClose = new Button("Close");

	public GraphNamePrint() {
		super("GraphNamePrint");
		// BorderLayout�� GUI ������Ʈ�� ��������,�߾� �� �ϳ��� ��ġ�Ѵ�.
		setLayout(new BorderLayout());

		setBackground(Color.lightGray);
		textGraph.setEditable(false);
		canvasGraph.setSize(500, 500);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(textGraph, BorderLayout.NORTH);
		panel.add(textGraph2, BorderLayout.SOUTH);

		// �� GUI ������Ʈ�� ��, �߾�, ���� �ܴ�.
		add(panel, BorderLayout.NORTH);
		add(canvasGraph, BorderLayout.CENTER);
		add(buttonClose, BorderLayout.SOUTH);
		// Close ��ư�� ������ ���� ActionListener�� ����Ѵ�.
		buttonClose.addActionListener(this);
		
		pack(); // ������ ũ�⸦ �����Ѵ�.
		show(); // ȭ�鿡 ���δ�.
		//setVisible(true);
	}

	// Close ��ư�� ������ �� ȣ��ȴ�.
	public void actionPerformed(ActionEvent e) {
		System.out.println("" + e);
		System.exit(0);
	}

	public void update(NumberGenerator generator) {
		textGraph.update(generator);
		textGraph2.update(generator);
		canvasGraph.update(generator);
	}
}
// ����Ŭ���� (���� �������� ��� ����)
class GraphText extends TextField implements Observer {
	public GraphText(int columns) {
		super(columns);
	}

	public void update(NumberGenerator generator) {
		int number = generator.getNumber();
		String text = number + ":";
		for (int i = 0; i < number; i++) {
			text += " ����ȣ";
		}
		setText(text); // ���� ������ �����ϰ� ���
	}
}

//����Ŭ���� (���� �������� ��� ����)
// Canvas: �׸� �׸� �� �ִ� �� �簢���� ��Ÿ���� Ŭ����
class GraphCanvas extends Canvas implements Observer {
	private int number;

	public void update(NumberGenerator generator) {
		number = generator.getNumber();
		repaint();  // paint() �޼ҵ带 �ڵ����� ȣ���Ѵ�.

	}

	// Graphics: �׸� �׸��� ���� ���� ���� �޼ҵ�� 
	// �׸��� ���� ����(����, ��Ʈ ��)�� ������ �ִ� Ŭ����
	// paint() �޼ҵ�� Graphics ��ü�� ���ڷ� ���޹޴´�.
	public void paint(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		// ���� ���� ������� �����Ѵ�.
		g.setColor(Color.white);
		// 0������ 360���� ��ȣ�� �׸���.
		g.fillArc(0, 0, width, height, 0, 360); //��ȣ�� �׸�
        // ���� ���� ���������� �����Ѵ�.
		g.setColor(Color.red);
		// 90������ �ð�������� ��ȣ�� �׸���.
		g.fillArc(0, 0, width, height, 90, -number * 360 / 50);
	}
}
