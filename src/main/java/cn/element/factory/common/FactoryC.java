package cn.element.factory.common;

public class FactoryC implements IFactory {

    @Override
    public IProduct makeProduct() {
        return new ProductC();
    }
}
