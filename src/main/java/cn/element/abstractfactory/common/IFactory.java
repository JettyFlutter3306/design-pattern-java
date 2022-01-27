package cn.element.abstractfactory.common;

/**
 * 抽象工厂
 *
 * 抽象工厂模式(Abstract Factory Pattern)指提供一个创建一系列相关或相互依赖对象的接口
 * 无须指定它们具体的类.意思就是客户端不必指定产品的具体类型,创建多个产品族中产品对象.
 *
 * 在抽象工厂模式中,客户端(应用层)不依赖产品类实例如何被创建,实现等细节,强调一系列相关的
 * 产品对象(属于同一产品族)一起创建对象,需要大量重复的代码.
 * 需要提供一个产品类的库,所有产品以同样的接口出现,从而使客户端不依赖具体实现.
 */
public interface IFactory {

    IProductA makeProductA();

    IProductB makeProductB();

}
