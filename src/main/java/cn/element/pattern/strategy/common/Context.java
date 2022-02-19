package cn.element.pattern.strategy.common;

public class Context {

    private final IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void algorithm() {
        strategy.algorithm();
    }

}
