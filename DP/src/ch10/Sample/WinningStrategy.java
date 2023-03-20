package ch10.Sample;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;  
    // 지난번 승부에서 이겼으면 true, 졌으면 false 저장
    private boolean won = false;
    private Hand prevHand; // 지난번 승부에서 내민 손 저장

    public WinningStrategy(int seed) {
        random = new Random(seed); //seed가 동일하면 난수가 같은 순서로 발생
        // 서로 다른 난수를 만들기 위해서는 seed도 매번 달라져야 함
	}

    public Hand nextHand() {
        if (!won) { // 직전에 졌으면
            prevHand = Hand.getHand(random.nextInt(3)); // 새로운 손을 얻는다
        }
        return prevHand; // 이겼으면, 직전 손이 그대로 반환된다.
    }

    public void study(boolean win) {
        won = win; // 지난번 승부를 저장함
    }
}
