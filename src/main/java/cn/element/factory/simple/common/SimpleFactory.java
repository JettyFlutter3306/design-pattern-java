package cn.element.factory.simple.common;

public class SimpleFactory {

    public static IProduct makeProduct(Constant kind) {
        switch (kind) {
            case PRODUCT_A:
                return new ProductA();
            case PRODUCT_B:
                return new ProductB();
            case PRODUCT_C:
                return new ProductC();
            default:
                return null;
        }
    }

}
