package ch10.Sample;

import java.util.Random;

public class ProbStrategy implements Strategy {
	private Random random;
	//최근 손 2개가 필요
	// 지난번에 냈던 손
	private int prevHandValue = 0;

	// 이번에 냈던 손
	private int currentHandValue = 0;

	private int[][] history = { { 1, 1, 1, }, { 1, 1, 1, }, { 1, 1, 1, } }; //초기화

	public ProbStrategy(int seed) {
		random = new Random(seed);
	}

	// 이 메소드 안에 전략이 들어가 있다.
	public Hand nextHand() {
		// 현재 손으로 이긴 횟수를 모두 더한후 이것을 이용해서 임의의 수를 얻는다.
		int bet = random.nextInt(getSum(currentHandValue)); //currentHandValue : 행번호
		int handvalue = 0;

		if (bet < history[currentHandValue][0]) {
			handvalue = 0; // 바위
		} else if (bet < history[currentHandValue][0]+ history[currentHandValue][1]) //3+5=8
		{
			handvalue = 1; // 가위
		} else {
			handvalue = 2; // 보
		}
		prevHandValue = currentHandValue; // 이전 손을 현재 손으로 대치함.
		currentHandValue = handvalue; // 현재 손을 이제 내밀 손으로 대치함.
		return Hand.getHand(handvalue);
	}

	// hv를 내서 이겼던 모든 횟수를 반환한다.(2차원 배열에서 hv 행을 다 더한다)
	private int getSum(int hv) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += history[hv][i]; //hv행의 열을 더함
		}
		return sum; //더한 결과를 반환
	}

	public void study(boolean win) {
		if (win) { // 이번에 이겼으면, 이번에 냈던 손에 1을 더함
			history[prevHandValue][currentHandValue]++;
			//2를 더하는 경우
			//history[prevHandValue][currentHandValue] +=2;
		} else { // 이번에 졌으면, 이번에 내지 않았던 두 손에 1을 더한다.
			history[prevHandValue][(currentHandValue + 1) % 3]++; //2 + 1 = 3 => 0
			history[prevHandValue][(currentHandValue + 2) % 3]++; //2 + 2 = 4 => 1
		}
		//모든 수를 0~10으로 변환하겠다 => n%11
	}
}
