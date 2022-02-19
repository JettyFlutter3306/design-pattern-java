package cn.element.pattern.factory.simple.common;

/**
 * 具体产品A
 */
public class ProductA implements IProduct {

    @Override
    public void doSomething() {
        System.out.println("I am Product A");
    }
}
