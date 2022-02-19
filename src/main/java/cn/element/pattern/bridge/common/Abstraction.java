package cn.element.pattern.bridge.common;

/**
 * 桥接模式(Bridge Pattern)又叫作桥梁模式,接口模式或柄体(Handle and Body)模式
 * 指将抽象部分与具体实现部分分离,使它们都可以独立地变化,属于结构型设计模式
 *
 * 桥接模式的主要目的是通过组合的方式建立两个类之间的联系,而不是继承,但又类似多重继承
 * 方案.但是多重继承方案往往违背了类的单一职责原则,其复用性比较差,桥接模式是比多重继承
 * 方案更好的替代方案.桥接模式的核心在于把抽象与实现解耦
 *
 * 抽象
 */
public abstract class Abstraction {

    protected IImplementor implementor;

    public Abstraction(IImplementor implementor) {
        this.implementor = implementor;
    }

    public void operation() {
        implementor.operationImpl();
    }
}