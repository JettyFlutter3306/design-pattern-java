package cn.element.decorator.common;

/**
 * 具体装饰器B
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
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
        super.operation();
        operationLast();
    }


}
