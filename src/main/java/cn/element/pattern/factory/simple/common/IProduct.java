package cn.element.pattern.factory.simple.common;

/**
 * 简单工厂模式(Simple Factory Pattern)又叫作静态工厂模式(Static Factory Method)
 * 简单来说,简单工厂模式有一个具体的工厂类,可以生成多个不同的产品,属于创建型设计模式
 * 简单工厂模式不在GoF23种设计模式之列.
 *
 * 简单工厂创建的所有对象的父类,负责描述所有实例共有的公共接口
 */
public interface IProduct {

    void doSomething();
}
