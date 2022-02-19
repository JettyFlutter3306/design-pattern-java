package cn.element.pattern.factory.common;

public class FactoryC implements IFactory {

    @Override
    public IProduct makeProduct() {
        return new ProductC();
    }
}
