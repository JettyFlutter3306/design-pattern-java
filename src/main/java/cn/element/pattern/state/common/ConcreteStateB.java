package cn.element.pattern.state.common;

public class ConcreteStateB implements IState {

    @Override
    public void handle() {
        System.out.println("StateB do action");
    }
}
