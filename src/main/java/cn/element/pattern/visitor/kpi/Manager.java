package cn.element.pattern.visitor.kpi;

import java.util.Random;

public class Manager extends Employee {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * 一年做的新产品的数量
     */
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
