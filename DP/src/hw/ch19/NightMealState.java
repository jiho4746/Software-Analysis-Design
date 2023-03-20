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
		// (1) ����Ϳ� ����� ����
		context.recordLog("����ȣ - �߽Ľð� : �ݰ���(�߰�)");
		// (2) ������ �뺸�� ��
		context.callSecurityCenter("����ȣ - �߽Ľð� : ��� : �߰��� �ݰ���");
	}

	public void doAlarm(Context context) {
		// ����Ϳ� ��� �뺸�� ��
		context.callSecurityCenter("����ȣ - �߽Ľð� : ���(�߰�)");
	}

	public void doPhone(Context context) {
		// ������� �ڵ�����Ⱑ ȣ���
		 context.recordLog("����ȣ - �߽Ľð� : �߰��� ��ȭ ����");
	}
	
	public void doCCTV(Context context) {
		context.recordLog("CCTV: Off");
	}
	public String toString() {                          // ���ڿ� ǥ��
        return "[�߽Ľð�]";
    }
}
