package cn.element.state.common;

public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteStateB());
        context.handle();
    }
}
