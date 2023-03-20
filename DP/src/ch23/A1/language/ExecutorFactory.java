package ch23.A1.language;

public interface ExecutorFactory {
	// 뭔가 액션을 취하는 Executor 객체를 생성하는 메소드
    public abstract Executor createExecutor(String name);
}
