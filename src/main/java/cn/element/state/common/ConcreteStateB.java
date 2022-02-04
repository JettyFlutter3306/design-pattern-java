package cn.element.state.common;

public class ConcreteStateB implements IState {

    @Override
    public void handle() {
        System.out.println("StateB do action");
    }
}
