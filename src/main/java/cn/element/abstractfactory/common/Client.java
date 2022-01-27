package cn.element.abstractfactory.common;

public class Client {

    public static void main(String[] args) {
        IFactory factory = new ConcreteFactoryA();
        factory.makeProductA().doA();
        factory.makeProductB().doB();

        factory = new ConcreteFactoryB();
        factory.makeProductA().doA();
        factory.makeProductB().doB();
    }

}
