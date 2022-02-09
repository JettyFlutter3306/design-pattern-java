package cn.element.visitor.common;

import java.util.Random;

public class ConcreteElementB implements IElement {

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public int operationB() {
        return new Random().nextInt(1000);
    }
}
