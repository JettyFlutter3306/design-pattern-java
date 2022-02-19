package cn.element.pattern.decorator.common;

public class Client {

    public static void main(String[] args) {
        // 首先创建需要被装饰的原始对象(即要被装饰的对象)
        Component c1 = new ConcreteComponent();

        // 给对象透明地增加功能A并调用
        Decorator decoratorA = new ConcreteDecoratorA(c1);
        decoratorA.operation();

        Decorator decoratorB = new ConcreteDecoratorB(c1);
        decoratorB.operation();

        // 装饰器也可以装饰具体的装饰对象,此时相当于给对象在增加功能A的基础上再增加功能B
        Decorator decoratorBAndA = new ConcreteDecoratorB(decoratorA);
        decoratorBAndA.operation();
    }

}
