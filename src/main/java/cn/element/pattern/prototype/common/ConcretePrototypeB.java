package cn.element.pattern.prototype.common;

public class ConcretePrototypeB implements IPrototype<ConcretePrototypeB>, Cloneable {

    protected String desc;

    public ConcretePrototypeB(String desc) {
        this.desc = desc;
    }

    @Override
    public ConcretePrototypeB clone() {
        return new ConcretePrototypeB(this.desc);
    }

    @Override
    public String toString() {
        return "ConcretePrototypeB{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
