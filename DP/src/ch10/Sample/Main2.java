package ch10.Sample;

public class Main2 {

	public static void main(String[] args) {
		/*
		Hand h1 = new Hand(Hand.HANDVALUE_GUU); //주먹
		Hand h2 = new Hand(Hand.HANDVALUE_PAA); //보
		
		if (h1.isStrongerThan(h2)) {
			System.out.println("h1이 이긴다");
		}
		if (h1.isWeakerThan(h2)) {
			System.out.println("h1이 진다");
		}
		System.out.println(h1.toString()); //현재 손 출력
		*/
		
		Player p1 = new Player("박지호", new ProbStrategy(100));
		Player p2 = new Player("유재석", new WinningStrategy(200));
		
		for(int i=0; i<=10000; i++) { //가위바위보 100번 진행
			//손 2개를 만들어 변수에 넣음
			Hand h1 = p1.nextHand();
			Hand h2 = p2.nextHand();
			
			if(i==5000) {
				p2.setStrategy(new ProbStrategy(300)); //실행 중에 Strategy 변경 가능
			}
			
			if (h1.isStrongerThan(h2)) {
				System.out.println("Winner: "+p1);
				p1.win(); //이겼음을 알림
				p2.lose(); //졌음을 알림
			}
			else if(h2.isStrongerThan(h1)) {
				System.out.println("Winner: "+p2);
				p2.win(); 
				p1.lose(); 
			}
			else {
				System.out.println("Even");
				p1.even(); //비겼음을 알림
				p2.even();
			}
		}
		System.out.println("Total result: ");
		System.out.println(" "+ p1); // p1.toString() 자동으로 호출됨
		System.out.println(p2); // p2.toString() 자동으로 호출됨
	}
}
