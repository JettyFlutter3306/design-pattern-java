package cn.element.factory.simple.common;

/**
 * 具体产品ProductC
 */
public class ProductC implements IProduct {

    @Override
    public void doSomething() {
        System.out.println("I am Product C");
    }
}
