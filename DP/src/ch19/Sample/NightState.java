package ch19.Sample;

// 야간의 상태를 나타내는 클래스
public class NightState implements State {
	private static NightState singleton = new NightState();

	private NightState() { // 생성자는 private
	}

	public static State getInstance() { // 유일한 하나의 인스턴스를 얻는다.
		return singleton;
	}

	public void doClock(Context context, int hour) { // 시각설정
		// 인자에서 제공된 시각이 주간의 시각이면, 
		if (9 <= hour && hour < 17) {
			context.changeState(DayState.getInstance()); // 시스템의 상태를 주간으로 바꾼다.
		}
	}

	public void doUse(Context context) { // 금고사용
		context.callSecurityCenter("비상:야간의 금고사용");
	}

	public void doAlarm(Context context) { // 비상벨
		context.callSecurityCenter("비상벨(야간)");
	}

	public void doPhone(Context context) { // 일반 통화
		context.recordLog("야간의 통화 녹음");
	}

	public String toString() { // 문자열 표현
		return "[야간]";
	}
}
