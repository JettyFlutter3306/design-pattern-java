package cn.element.abstractfactory.common;

/**
 * 工厂类A
 */
public class ConcreteFactoryA implements IFactory {

    @Override
    public IProductA makeProductA() {
        return new ConcreteProductAWithFamilyA();
    }

    @Override
    public IProductB makeProductB() {
        return new ConcreteProductBWithFamilyA();
    }
}
