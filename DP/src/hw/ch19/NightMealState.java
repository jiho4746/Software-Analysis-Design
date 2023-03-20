package hw.ch19;

public class NightMealState implements State{
	private static NightMealState singleton = new NightMealState();
    private NightMealState() {                              
    }
    public static State getInstance() {
        return singleton;
    }
	
	public void doClock(Context context, int hour) {
		if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        } else if (12 <= hour && hour < 13) {                   
            context.changeState(NoonState.getInstance());       
        } else if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
	}

	public void doUse(Context context) {
		// (1) 경비센터에 기록이 남음
		context.recordLog("박지호 - 야식시간 : 금고사용(야간)");
		// (2) 비상사태 통보가 감
		context.callSecurityCenter("박지호 - 야식시간 : 비상 : 야간의 금고사용");
	}

	public void doAlarm(Context context) {
		// 경비센터에 비상벨 통보가 감
		context.callSecurityCenter("박지호 - 야식시간 : 비상벨(야간)");
	}

	public void doPhone(Context context) {
		// 경비센터의 자동응답기가 호출됨
		 context.recordLog("박지호 - 야식시간 : 야간의 통화 녹음");
	}
	
	public void doCCTV(Context context) {
		context.recordLog("CCTV: Off");
	}
	public String toString() {                          // 문자열 표현
        return "[야식시간]";
    }
}
