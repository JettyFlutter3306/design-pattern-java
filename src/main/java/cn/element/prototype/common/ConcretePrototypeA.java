package cn.element.prototype.common;

/**
 * 具体原型
 */
public class ConcretePrototypeA implements IPrototype<ConcretePrototypeA>, Cloneable {

    protected String desc;

    public ConcretePrototypeA(String desc) {
        this.desc = desc;
    }

    @Override
    public ConcretePrototypeA clone() {
        return new ConcretePrototypeA(this.desc);
    }

    @Override
    public String toString() {
        return "ConcretePrototypeA{" +
                "des='" + desc + '\'' +
                '}';
    }
}
