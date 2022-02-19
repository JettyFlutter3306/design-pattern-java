package cn.element.pattern.prototype.common;

/**
 * 抽象原型
 * 原型模式(Prototype Pattern)值原型实例指定创建对象的种类,并且通过复制这些原型
 * 创建新的对象,属于创建型设计模式.
 */
public interface IPrototype<T> {

    T clone();
}
