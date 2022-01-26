package cn.element.factory.common;

public class Client {

    public static void main(String[] args) {
        IFactory factory = new FactoryA();
        factory.makeProduct().doSomething();

        factory = new FactoryB();
        factory.makeProduct().doSomething();

        factory = new FactoryC();
        factory.makeProduct().doSomething();
    }

}
