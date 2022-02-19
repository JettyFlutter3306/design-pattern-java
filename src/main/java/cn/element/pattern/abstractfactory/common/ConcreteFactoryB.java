package cn.element.pattern.abstractfactory.common;

public class ConcreteFactoryB implements IFactory {

    @Override
    public IProductA makeProductA() {
        return new ConcreteProductAWithFamilyB();
    }

    @Override
    public IProductB makeProductB() {
        return new ConcreteProductBWithFamilyB();
    }
}
