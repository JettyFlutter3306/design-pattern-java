package cn.element.factory.common;

public class FactoryB implements IFactory {

    @Override
    public IProduct makeProduct() {
        return new ProductB();
    }
}
