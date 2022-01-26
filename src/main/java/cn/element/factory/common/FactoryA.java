package cn.element.factory.common;

public class FactoryA implements IFactory {

    @Override
    public IProduct makeProduct() {
        return new ProductA();
    }
}
