package cn.element.pattern.state.auto;

public class Context {

    public static final State STATE_A = new ConcreteStateA();
    public static final State STATE_B = new ConcreteStateB();

    // 默认状态A
    private State currentState = STATE_A;

    {
        STATE_A.setContext(this);
        STATE_B.setContext(this);
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    public State getCurrentState() {
        return currentState;
    }

    public void handle() {
        currentState.handle();
    }
}
