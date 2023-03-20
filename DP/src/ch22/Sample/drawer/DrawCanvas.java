package ch22.Sample.drawer;

import ch22.Sample.command.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Drawable 인터페이스를 구현하고, java.awt.Canvas 를 상속함
public class DrawCanvas extends Canvas implements Drawable {
	// 그림 그리는 색
	private Color color = Color.red;

	// 그림 그리기를 할 점의 변경
	private int radius = 6;

	// 지금까지 실행한 그림 그리기 명령어들의 집합을 가지고 있음
	private MacroCommand history;

	// 폭, 높이, 그림 그리기 이력(history)를 받아서,
	// DrawCanvas 인스턴스를 초기화한다.
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
	}

	// DrawCanvas를 다시 그릴 필요가 생겼을 때
	// java.awt 프레임워크로부터 자동으로 호출되는 메소드
	// repaint( ) 메소드가 호출되면, 화면이 지워진 후 자동으로 paint( ) 메소드가 실행된다.
	public void paint(Graphics g) {
		// history가 보관하고 있는 모든 그리기 명령들을 실행한다.
		history.execute();
	}

	// 그리기
	public void draw(int x, int y) {
		// Graphics 객체를 얻어서,
		Graphics g = getGraphics();
		// 색깔을 빨간색으로 지정하고
		g.setColor(color);
		// Graphics 객체의 filloval(x, y, 사각형 가로, 사각형 세로)을 
		// 이용하여 원을 그린다.
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
}
