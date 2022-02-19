package cn.element.pattern.state.common;

/**
 * 具体状态类
 */
public class ConcreteStateA implements IState {

    @Override
    public void handle() {
        System.out.println("StateA do action");
    }
}
