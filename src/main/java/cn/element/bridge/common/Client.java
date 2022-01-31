package cn.element.bridge.common;

public class Client {

    public static void main(String[] args) {
        // 创建一个具体角色
        IImplementor implementor = new ConcreteImplementorA();

        // 创建一个抽象角色,聚合实现
        Abstraction abstraction = new RefinedAbstraction(implementor);

        // 执行操作
        abstraction.operation();
    }
}
