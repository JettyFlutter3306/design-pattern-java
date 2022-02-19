package cn.element.pattern.abstractfactory.common;

/**
 * 产品族A的具体产品A
 */
public class ConcreteProductAWithFamilyA implements IProductA {

    @Override
    public void doA() {
        System.out.println("The ProductA be part of FamilyA");
    }
}
