package ch19.Sample;

// 주간의 상태를 나타내는 클래스
public class DayState implements State {
	// 하나의 상태만 필요하므로, Singleton 패턴을 사용함
	private static DayState singleton = new DayState();

	private DayState() { // 생성자는 private
	}

	public static State getInstance() { // 유일한 하나의 인스턴스를 얻는다.
		return singleton;
	}

	// 시각을 설정하는 메소드
	public void doClock(Context context, int hour) { 
		// 인자에서 제공된 시각이 야간의 시각이면, 
		if (hour < 9 || 17 <= hour) {
			context.changeState(NightState.getInstance()); // 시스템의 상태를 야간으로 바꾼다.
		}
	}

// “주간 상태”에서 하는 일을 표현하는 메소드

	// 금고 사용을 나타내는 메소드
	public void doUse(Context context) { 
		context.recordLog("금고사용(주간)"); // 주간에 금고를 사용했음을 기록
	}

	// 비상벨로 경비센터를 호출하는 메소드
	public void doAlarm(Context context) { // 비상벨
		context.callSecurityCenter("비상벨(주간)");
	}

	// 경비센터에 일반통화를 함
	public void doPhone(Context context) { 
		context.callSecurityCenter("일반 통화(주간)");
	}

	public String toString() { // 문자열 표현
		return "[주간]";
	}
}
