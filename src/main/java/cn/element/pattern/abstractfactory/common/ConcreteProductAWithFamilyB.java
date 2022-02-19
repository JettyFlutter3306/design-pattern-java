package cn.element.pattern.abstractfactory.common;

public class ConcreteProductAWithFamilyB implements IProductA {

    @Override
    public void doA() {
        System.out.println("The ProductA be part of FamilyB");
    }
}
