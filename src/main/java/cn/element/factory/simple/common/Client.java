package cn.element.factory.simple.common;

import java.util.Objects;

public class Client {

    public static void main(String[] args) {
        Objects.requireNonNull(SimpleFactory.makeProduct(Constant.PRODUCT_A))
               .doSomething();
    }

}
