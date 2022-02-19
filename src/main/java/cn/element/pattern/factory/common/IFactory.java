package cn.element.pattern.factory.common;

/**
 * 抽象工厂
 *
 * 工厂方法模式(Factory Method Pattern)又叫作多态性工厂模式,指定义一个创建对象的接口,
 * 但由实现这个接口的类来决定实例化哪个类,工厂方法把类的实例化推迟到子类进行.
 *
 * 在工厂方法模式中,不再由单一的工厂类生产产品,而是由工厂类的子类实现具体产品的创建.因此
 * 当增加一个产品时,只需增加一个相应的工厂类的子类,实现这种产品,便可以解决简单工厂生产
 * 太多产品导致其内部代码臃肿(switch... case分支过多)的问题,也符合开闭原则.
 */
public interface IFactory {

    IProduct makeProduct();

}
