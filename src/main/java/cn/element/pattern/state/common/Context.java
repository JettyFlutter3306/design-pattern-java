package cn.element.pattern.state.common;

/**
 * 环境类
 */
public class Context {

    private static final IState STATE_A = new ConcreteStateA();
    private static final IState STATE_B = new ConcreteStateB();

    // 默认状态类
    private IState currentState = STATE_A;

    public void setCurrentState(IState currentState) {
        this.currentState = currentState;
    }

    public void handle() {
        currentState.handle();
    }
}
