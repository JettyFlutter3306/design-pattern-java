package cn.element.abstractfactory.common;

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
