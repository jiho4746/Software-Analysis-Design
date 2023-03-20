package hw.ch20;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BigCharGui extends JFrame{
	private static BigString[] bsarray = new BigString[1000];
	private TextField inputText = new TextField(60);
	private JButton use1Btn = new JButton("공유해서 큰 문자 생성");
	private TextField use1Text = new TextField(60);
	private JScrollPane use1Scroll = new JScrollPane(new JTextArea("", 60, 60));
	//private JTextArea use1Scroll = new JTextArea("", 60, 80);
	
	private JButton use2Btn = new JButton("공유하지 않고 큰 문자 생성");
	private TextField use2Text = new TextField(60);
	private JScrollPane use2Scroll = new JScrollPane(new JTextArea("", 60, 60));
	//private JTextArea use2Scroll = new JTextArea("", 60, 80);
	
	
	public BigCharGui() {
		setTitle("20200769 박지호");
		setSize(800, 800);
		buildGUI();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	private void buildGUI() {
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		//입력값 출력 텍스트
		c.add(inputText, BorderLayout.NORTH);
		
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add(use1Btn, BorderLayout.NORTH);
		panel1.add(use1Text, BorderLayout.CENTER);
		
		JPanel panel11 = new JPanel(new BorderLayout());
		panel11.add(panel1, BorderLayout.NORTH);
		panel11.add(use1Scroll, BorderLayout.CENTER);
		
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.add(use2Btn, BorderLayout.NORTH);
		panel2.add(use2Text, BorderLayout.CENTER);
		
		JPanel panel22 = new JPanel(new BorderLayout());
		panel22.add(panel2, BorderLayout.NORTH);
		panel22.add(use2Scroll, BorderLayout.CENTER);
		
		JPanel panel3 = new JPanel(new GridLayout(0,2));
		panel3.add(panel11);
		panel3.add(panel22);
		
		c.add(panel3, BorderLayout.CENTER);
		
		
		 use1Btn.addActionListener( new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					 Runtime.getRuntime().gc();
				     long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
				     use1Text.setText("메모리 사용량 = " + used);
				     
				     for (int i = 0; i < bsarray.length; i++) {
				            bsarray[i] = new BigString("1212123", true);
				        }
				}            
	        });
		 
		 use2Btn.addActionListener( new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					 Runtime.getRuntime().gc();
				     long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
				     use2Text.setText("메모리 사용량 = " + used);
				     
				     for (int i = 0; i < bsarray.length; i++) {
				            bsarray[i] = new BigString("1212123", false);
				        }
				}            
	        });
	}
}

