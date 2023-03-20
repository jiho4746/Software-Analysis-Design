package ch16.A1;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;
    public ColleagueButton(String caption) {
        super(caption);
    }
    public void setMediator(Mediator mediator) {            // Mediator�� ����
        this.mediator = mediator;
    }
    public void setColleagueEnabled(boolean enabled) {      // Mediator�� ��ȿ/��ȿ�� �����Ѵ�.
        setEnabled(enabled);
    }
}
