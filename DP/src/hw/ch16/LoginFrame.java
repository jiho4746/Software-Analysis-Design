package hw.ch16;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

// 중재자 역할을 하는 클래스
public class LoginFrame extends Frame implements ActionListener, Mediator {
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueCheckbox checkMember;

	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueTextField textMember;
	
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;

	// 생성자
	// Colleague들을 생성해서 배치한 후에 표시를 실행한다.
	public LoginFrame(String title) {
		super(title);
		// 배경색의 설정(setBackground( ) 이용)
		setBackground(Color.lightGray);
		// 즉, 프레임 영역을 5행 3열로 나눔
		setLayout(new GridLayout(5, 3));
		
		// Colleague들의 생성
		createColleagues();
		
		// 생성된 Colleague들을 배치
		add(checkGuest);
		add(checkLogin);
		add(checkMember);
		
		add(new Label("Username:"));
		add(textUser);
		add(new Label(""));
		
		add(new Label("Password:"));
		add(textPass);
		add(new Label(""));
		
		add(new Label("주민등록번호:"));
		add(textMember);
		add(new Label(""));
		
		add(buttonOk);
		add(buttonCancel);
		add(new Label(""));
		
		// 각 체크박스 유효/무효를 초기화한다.
		colleagueChanged(checkGuest);
		
		// 표시
		pack(); // 포함된 컴포넌트들의 레이아웃(배치 상태)에 맞게 윈도우 크기를 조정한다.
		show(); // 윈도우를 보여준다.
	}

	// Colleague들을 생성한다.
	public void createColleagues() {
		// 생성
		// Checkbox 생성 
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		checkMember = new ColleagueCheckbox("Member", g, false);
		
		textUser = new ColleagueTextField("", 10);
		
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		
		textMember = new ColleagueTextField("", 10);
		
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		
		// Mediator를 설정한다. 각 GUI 컴포넌트의 중재자는 현재 클래스 자신이다.
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		checkMember.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		textMember.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		
		// Listener들을 설정한다.
		checkGuest.addItemListener(checkGuest); // 자신이 이벤트 리스너가 된다
		checkLogin.addItemListener(checkLogin); // 자신이 이벤트 리스너가 된다
		checkMember.addItemListener(checkMember); // 자신이 이벤트 리스너가 된다
		textUser.addTextListener(textUser); // 자신이 이벤트 리스너가 된다
		textPass.addTextListener(textPass); // 자신이 이벤트 리스너가 된다
		textMember.addTextListener(textMember); // 자신이 이벤트 리스너가 된다
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	// colleague의 상태가 변화했을 때, 호출되는 메소드
	// Colleague로부터의 통지가 오면, 통지의 종류를 파악하여 각 Colleague의 유효/무효를 판정한다.
	// colleague의 상태 변화에 따라 해당 colleague의 상태를 
	// 어떻게 변화시킬 것인가에 대한 로직을 가지고 있다.
	public void colleagueChanged(Colleague c) {
		// 상태변화가 발생한 곳이 checkGuest, checkLogin, checkMember이면...
		if (c == checkGuest || c == checkLogin || c == checkMember) {
			if (checkGuest.getState()) { // checkGuest가 체크되었다면...
				textUser.setColleagueEnabled(false);
				textPass.setColleagueEnabled(false);
				textMember.setColleagueEnabled(false); //textMember는 비활성화
				buttonOk.setColleagueEnabled(false);
			} 
			else if (checkLogin.getState()){ // checkLogin이 체크되었다면...
				textUser.setColleagueEnabled(true);
				userpassChanged();  // user name 이나 password 텍스트필드가 바뀐 것이므로...
			}
			else {
				//member 라디오 버튼이 선택되면, Username 란이 활성화
				textUser.setColleagueEnabled(true);
				userpassChanged();
			}
		}
		// 상태변화가 발생한 곳이 textUser, textPass, textMember이면...
		else if (c == textUser || c == textPass || c==textMember) {
			userpassChanged();
		}
		else {
			System.out.println("colleagueChanged:unknown colleague = " + c);
		}
	}

	// TextField 상태 변화에 따라 버튼 활성화/비활성화한다.
	private void userpassChanged() {
		if (textUser.getText().length() > 0) { // textUser에 값이 들어가 있다면...
			textPass.setColleagueEnabled(true); // textPass를 유효화 시킨다.
			if (textPass.getText().length() > 0) { // textPass에 값이 들어가 있다면...
				textMember.setColleagueEnabled(true); // textPass를 유효화 시킨다.
				if(isTrue(textMember) == true) {
					if(textMember.getText().length() == 13) {//textMember에 값이 13개 이상이면
						buttonOk.setColleagueEnabled(true); // buttonOk를 유효화시킨다.
					}
				}
				else { // 숫자 이외의 문자를 입력하면 문자를 입력하느 순간 문자를 입력하지 말라고 경고창 뜸
					JOptionPane.showMessageDialog(null, "문자를 입력하지 마세요", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					//주민등록번호 입력했던 한 문자는 사라짐
					int size = textMember.getText().length();
					String newMember = textMember.getText().substring(0, size-1);
					textMember.setText(newMember);
					
					//다시 그 위치부터 주민번호 입력이 가능
					//가장 마지막에 커서를 위치시킴
					textMember.setCaretPosition(textMember.getText().length());
					buttonOk.setColleagueEnabled(false); // textMember에 값이 들어가 있지 않다면...
				}
			}
			else {
				buttonOk.setColleagueEnabled(false); // textPass에 값이 들어가 있지 않다면...
			}
		} else { // textUser에 값이 들어가 있지 않다면... textPass, textMemebr와 buttonOk를 무효화시킨다.
			textPass.setColleagueEnabled(false);
			textMember.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}

	private boolean isTrue(ColleagueTextField textMember2) {
		String text = textMember2.getText();
		boolean isNumeric = true;
		for(int i=0; i<text.length(); i++) {
			if(!Character.isDigit(text.charAt(i))) {
				isNumeric = false;
			}
		}
		return isNumeric;
	}

	// OK, Cancel 버튼이 눌러졌을 때 실행되는 메소드
	public void actionPerformed(ActionEvent e) { // 버튼이 눌려지면
	
		System.out.println("" + e); // 발생된 이벤트에 대한 설명을 화면에 출력하고
		System.exit(0); // 프로그램을 종료한다.
	}
}
