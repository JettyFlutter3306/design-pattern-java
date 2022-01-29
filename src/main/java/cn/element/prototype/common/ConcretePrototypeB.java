package cn.element.prototype.common;

public class ConcretePrototypeB implements IPrototype<ConcretePrototypeB> {

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
