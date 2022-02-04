package cn.element.state.auto;

/**
 * 具体状态类
 */
public class ConcreteStateA extends State {

    @Override
    public void handle() {
        System.out.println("StateA do action");

        // A状态完成后自动切换到B状态
        context.setCurrentState(Context.STATE_B);
        context.getCurrentState().handle();
    }
}
