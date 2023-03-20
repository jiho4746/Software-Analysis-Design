package ch16.A1;

public interface Colleague {
	//ch16.a2 선언한 속성은 항상 상수, 값을 바꿀 수 없음
	//private final int a = 10;
	
    public abstract void setMediator(Mediator mediator);
    public abstract void setColleagueEnabled(boolean enabled);
}
