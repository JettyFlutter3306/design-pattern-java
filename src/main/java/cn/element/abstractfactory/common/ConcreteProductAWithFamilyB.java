package cn.element.abstractfactory.common;

public class ConcreteProductAWithFamilyB implements IProductA {

    @Override
    public void doA() {
        System.out.println("The ProductA be part of FamilyB");
    }
}
