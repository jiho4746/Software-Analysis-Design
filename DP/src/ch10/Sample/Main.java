package ch10.Sample;

// 두 플레이어를 생성하고 이들로 부터 다음 손을 얻어서 승부를 내는 일을 하는 클래스
public class Main {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java Main randomseed1 randomseed2");
			System.out.println("Example: java Main 314 15");
			System.exit(0);
		}

		// 난수생성기를 만드는데 사용되는 seed를 명령행 인자로 받아들여 정수로 바꾼다.
		// 같은 seed로 만들어진 두 개의 Random 객체는 똑같은 난수들을 차례로 발생시킨다. 
		int seed1 = Integer.parseInt(args[0]);
		int seed2 = Integer.parseInt(args[1]);

		// 서로 다른 전략을 가지는 선수 2명을 생성한다.
		Player player1 = new Player("홍길동", new WinningStrategy(seed1));
		Player player2 = new Player("임꺽정", new ProbStrategy(seed2));

		// 100번 시합을 시킨다.
		for (int i = 0; i < 100; i++) {
			Hand nextHand1 = player1.nextHand();
			Hand nextHand2 = player2.nextHand();
			if (nextHand1.isStrongerThan(nextHand2)) {
				System.out.println("Winner:" + player1);
				player1.win();
				player2.lose();
			} else if (nextHand2.isStrongerThan(nextHand1)) {
				System.out.println("Winner:" + player2);
				player1.lose();
				player2.win();
			} else {
				System.out.println("Even...");
				player1.even();
				player2.even();
			}
		}

		System.out.println("Total result:");
		System.out.println("" + player1);
		// System.out.println(player1); => 된다
		System.out.println("" + player2);
	}
}
