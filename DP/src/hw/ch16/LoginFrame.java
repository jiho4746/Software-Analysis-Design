package hw.ch16;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

// ������ ������ �ϴ� Ŭ����
public class LoginFrame extends Frame implements ActionListener, Mediator {
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueCheckbox checkMember;

	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueTextField textMember;
	
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;

	// ������
	// Colleague���� �����ؼ� ��ġ�� �Ŀ� ǥ�ø� �����Ѵ�.
	public LoginFrame(String title) {
		super(title);
		// ������ ����(setBackground( ) �̿�)
		setBackground(Color.lightGray);
		// ��, ������ ������ 5�� 3���� ����
		setLayout(new GridLayout(5, 3));
		
		// Colleague���� ����
		createColleagues();
		
		// ������ Colleague���� ��ġ
		add(checkGuest);
		add(checkLogin);
		add(checkMember);
		
		add(new Label("Username:"));
		add(textUser);
		add(new Label(""));
		
		add(new Label("Password:"));
		add(textPass);
		add(new Label(""));
		
		add(new Label("�ֹε�Ϲ�ȣ:"));
		add(textMember);
		add(new Label(""));
		
		add(buttonOk);
		add(buttonCancel);
		add(new Label(""));
		
		// �� üũ�ڽ� ��ȿ/��ȿ�� �ʱ�ȭ�Ѵ�.
		colleagueChanged(checkGuest);
		
		// ǥ��
		pack(); // ���Ե� ������Ʈ���� ���̾ƿ�(��ġ ����)�� �°� ������ ũ�⸦ �����Ѵ�.
		show(); // �����츦 �����ش�.
	}

	// Colleague���� �����Ѵ�.
	public void createColleagues() {
		// ����
		// Checkbox ���� 
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
		
		// Mediator�� �����Ѵ�. �� GUI ������Ʈ�� �����ڴ� ���� Ŭ���� �ڽ��̴�.
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		checkMember.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		textMember.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		
		// Listener���� �����Ѵ�.
		checkGuest.addItemListener(checkGuest); // �ڽ��� �̺�Ʈ �����ʰ� �ȴ�
		checkLogin.addItemListener(checkLogin); // �ڽ��� �̺�Ʈ �����ʰ� �ȴ�
		checkMember.addItemListener(checkMember); // �ڽ��� �̺�Ʈ �����ʰ� �ȴ�
		textUser.addTextListener(textUser); // �ڽ��� �̺�Ʈ �����ʰ� �ȴ�
		textPass.addTextListener(textPass); // �ڽ��� �̺�Ʈ �����ʰ� �ȴ�
		textMember.addTextListener(textMember); // �ڽ��� �̺�Ʈ �����ʰ� �ȴ�
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	// colleague�� ���°� ��ȭ���� ��, ȣ��Ǵ� �޼ҵ�
	// Colleague�κ����� ������ ����, ������ ������ �ľ��Ͽ� �� Colleague�� ��ȿ/��ȿ�� �����Ѵ�.
	// colleague�� ���� ��ȭ�� ���� �ش� colleague�� ���¸� 
	// ��� ��ȭ��ų ���ΰ��� ���� ������ ������ �ִ�.
	public void colleagueChanged(Colleague c) {
		// ���º�ȭ�� �߻��� ���� checkGuest, checkLogin, checkMember�̸�...
		if (c == checkGuest || c == checkLogin || c == checkMember) {
			if (checkGuest.getState()) { // checkGuest�� üũ�Ǿ��ٸ�...
				textUser.setColleagueEnabled(false);
				textPass.setColleagueEnabled(false);
				textMember.setColleagueEnabled(false); //textMember�� ��Ȱ��ȭ
				buttonOk.setColleagueEnabled(false);
			} 
			else if (checkLogin.getState()){ // checkLogin�� üũ�Ǿ��ٸ�...
				textUser.setColleagueEnabled(true);
				userpassChanged();  // user name �̳� password �ؽ�Ʈ�ʵ尡 �ٲ� ���̹Ƿ�...
			}
			else {
				//member ���� ��ư�� ���õǸ�, Username ���� Ȱ��ȭ
				textUser.setColleagueEnabled(true);
				userpassChanged();
			}
		}
		// ���º�ȭ�� �߻��� ���� textUser, textPass, textMember�̸�...
		else if (c == textUser || c == textPass || c==textMember) {
			userpassChanged();
		}
		else {
			System.out.println("colleagueChanged:unknown colleague = " + c);
		}
	}

	// TextField ���� ��ȭ�� ���� ��ư Ȱ��ȭ/��Ȱ��ȭ�Ѵ�.
	private void userpassChanged() {
		if (textUser.getText().length() > 0) { // textUser�� ���� �� �ִٸ�...
			textPass.setColleagueEnabled(true); // textPass�� ��ȿȭ ��Ų��.
			if (textPass.getText().length() > 0) { // textPass�� ���� �� �ִٸ�...
				textMember.setColleagueEnabled(true); // textPass�� ��ȿȭ ��Ų��.
				if(isTrue(textMember) == true) {
					if(textMember.getText().length() == 13) {//textMember�� ���� 13�� �̻��̸�
						buttonOk.setColleagueEnabled(true); // buttonOk�� ��ȿȭ��Ų��.
					}
				}
				else { // ���� �̿��� ���ڸ� �Է��ϸ� ���ڸ� �Է��ϴ� ���� ���ڸ� �Է����� ����� ���â ��
					JOptionPane.showMessageDialog(null, "���ڸ� �Է����� ������", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					//�ֹε�Ϲ�ȣ �Է��ߴ� �� ���ڴ� �����
					int size = textMember.getText().length();
					String newMember = textMember.getText().substring(0, size-1);
					textMember.setText(newMember);
					
					//�ٽ� �� ��ġ���� �ֹι�ȣ �Է��� ����
					//���� �������� Ŀ���� ��ġ��Ŵ
					textMember.setCaretPosition(textMember.getText().length());
					buttonOk.setColleagueEnabled(false); // textMember�� ���� �� ���� �ʴٸ�...
				}
			}
			else {
				buttonOk.setColleagueEnabled(false); // textPass�� ���� �� ���� �ʴٸ�...
			}
		} else { // textUser�� ���� �� ���� �ʴٸ�... textPass, textMemebr�� buttonOk�� ��ȿȭ��Ų��.
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

	// OK, Cancel ��ư�� �������� �� ����Ǵ� �޼ҵ�
	public void actionPerformed(ActionEvent e) { // ��ư�� ��������
	
		System.out.println("" + e); // �߻��� �̺�Ʈ�� ���� ������ ȭ�鿡 ����ϰ�
		System.exit(0); // ���α׷��� �����Ѵ�.
	}
}
