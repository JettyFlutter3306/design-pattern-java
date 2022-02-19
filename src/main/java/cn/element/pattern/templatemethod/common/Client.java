package cn.element.pattern.templatemethod.common;

public class Client {

    public static void main(String[] args) {
        AbstractClass abc = new ConcreteClassA();
        abc.templateMethod();

        abc = new ConcreteClassB();
        abc.templateMethod();
    }
}
