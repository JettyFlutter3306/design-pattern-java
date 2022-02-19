package cn.element.pattern.bridge.common;

public class ConcreteImplementorB implements IImplementor {

    @Override
    public void operationImpl() {
        System.out.println("I'm ConcreteImplementor B");
    }
}
