package cn.element.decorator.common;

/**
 * 具体装饰器A
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    /**
     * 在调用父类的operation方法之前需要执行的操作
     */
    private void operationFirst() {

    }

    /**
     * 在调用父类的operation方法之后需要执行的操作
     */
    private void operationLast() {

    }

    public void operation() {
        // 调用父类的方法,可以在调用前后执行一些附加动作
        operationFirst();

        // 这里可以选择性地调用父类的方法
        // 这里不调用,则相当于完全改写了方法,实现新的功能
        super.operation();
        operationLast();
    }
}
