package cn.element.pattern.factory.simple.common;

/**
 * 具体产品B
 */
public class ProductB implements IProduct {

    @Override
    public void doSomething() {
        System.out.println("I am Product B");
    }
}
