package ch10.Sample;

public class Player {
	private String name;
	
	 //부모 타입으로 선언되어 있음 -> 자식 중 누구든 가르킬 수 있음(Winning/Prob Strategy)
	private Strategy strategy; 

	private int wincount;

	private int losecount;

	private int gamecount;

//	 이름과 전략을 인자로 전달받는다.
	public Player(String name, Strategy strategy) { 
		this.name = name;
		this.strategy = strategy;
	}
	//Strategy 변경하는 메소드
	public void setStrategy (Strategy s){
		this.strategy = s;
	}
	
	public Hand nextHand() { // (중요!!) 전략의 지시를 받는다.
		return strategy.nextHand();
	}

	// 이겼을 때 호출되는 메소드
	public void win() { 
		strategy.study(true);
		wincount++;
		gamecount++;
	}
//	졌을 때 호출되는 메소드
	public void lose() {
		strategy.study(false);
		losecount++;
		gamecount++;
	}
//	비겼을 때 호출되는 메소드
	public void even() { // 무승부
		gamecount++;
	}

	public String toString() {
		return "[" + name + " / 이전 성적:" + gamecount + " games, " + wincount
				+ " win, " + losecount + " lose" + "]";
	}
}
