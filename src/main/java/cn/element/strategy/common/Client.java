package cn.element.strategy.common;

public class Client {

    public static void main(String[] args) {
        IStrategy strategy = new ConcreteStrategyA();

        Context context = new Context(strategy);

        context.algorithm();
    }
}
