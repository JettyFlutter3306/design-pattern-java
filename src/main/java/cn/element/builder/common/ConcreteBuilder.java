package cn.element.builder.common;

public class ConcreteBuilder implements IBuilder {

    private final Product product = new Product();

    public Product build() {
        return product;
    }




}
