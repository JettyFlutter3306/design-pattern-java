package cn.element.pattern.flyweight.common;

public class Client {

    public static void main(String[] args) {
        IFlyweight flyweight1 = FlyweightFactory.getFlyweight("aa");
        IFlyweight flyweight2 = FlyweightFactory.getFlyweight("bb");

        flyweight1.operation("a");
        flyweight2.operation("b");

        IFlyweight flyweight3 = FlyweightFactory.getFlyweight("aa");
        flyweight3.operation("a");
    }
}
