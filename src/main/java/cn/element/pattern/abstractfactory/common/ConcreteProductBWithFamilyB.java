package cn.element.pattern.abstractfactory.common;

public class ConcreteProductBWithFamilyB implements IProductB {

    @Override
    public void doB() {
        System.out.println("The ProductB be part of FamilyB");
    }
}
