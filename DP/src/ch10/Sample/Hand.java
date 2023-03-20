package ch10.Sample;

// 주먹, 가위, 보 3 종류의 손 배열을 가지고 있음.
// 이 셋 중 현재 손이 어떤 종류인지에 해당하는 값을 속성으로 가진다.
public class Hand {
	public static final int HANDVALUE_GUU = 0; // 주먹을 나타내는 값

	public static final int HANDVALUE_CHO = 1; // 가위를 나타내는 값

	public static final int HANDVALUE_PAA = 2; // 보를 나타내는 값

	// hand는 가위바위보의 손을 나타내는 3개의 인스턴스를 가지고 있는 배열
	public static final Hand[] hand = { new Hand(HANDVALUE_GUU),
			new Hand(HANDVALUE_CHO), new Hand(HANDVALUE_PAA), };

	private static final String[] name = { // 가위바위보의 손의 문자열 표현
	"주먹", "가위", "보", };

	private int handvalue; // 가위바위보의 손의 값

	/* 같은 패키지 내에서만 접근 가능
	    Hand(int handvalue) { Main2실행하기 위해서 private 지움
		this.handvalue = handvalue;
	}*/
	
	private Hand(int handvalue) { //아무나 손을 만들지 못하게 private
		this.handvalue = handvalue;
	}

	// 값으로부터 Hand 인스턴스를 얻는다.
	public static Hand getHand(int handvalue) {
		return hand[handvalue];
	}

	// this가 h보다 강할 때 true를 반환함
	public boolean isStrongerThan(Hand h) { // this가 h보다 강할 때 true
		return fight(h) == 1;
	}

	// this가 h보다 약할 때 true를 반환함
	public boolean isWeakerThan(Hand h) { // this가h보다 약할 때 true
		return fight(h) == -1;
	}

	// 무승부는 0, this가 이기면 1, h가 이기면 -1을 반환함
	private int fight(Hand h) {
		if (this == h) {
			return 0;
		} else if ((this.handvalue + 1) % 3 == h.handvalue) { // 예: 현재 손은 바위,
			// h가 바위+1(가위)이면
			// 현재 손이 이긴다.
			return 1;
		} else {
			return -1;
		}
	}

	// 문자열 표현으로 변환
	public String toString() {
		return name[handvalue];
	}
}
