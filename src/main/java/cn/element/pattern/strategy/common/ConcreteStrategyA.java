package cn.element.pattern.strategy.common;

public class ConcreteStrategyA implements IStrategy {

    @Override
    public void algorithm() {
        System.out.println("Strategy A");
    }
}
