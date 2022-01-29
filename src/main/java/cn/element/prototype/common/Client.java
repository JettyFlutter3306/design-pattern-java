package cn.element.prototype.common;

public class Client {

    public static void main(String[] args) {
        // 创建原型对象
        ConcretePrototypeA prototypeA = new ConcretePrototypeA("originalA");
        System.out.println(prototypeA);

        // 复制原型对象
        ConcretePrototypeA cloneTypeA = prototypeA.clone();
        cloneTypeA.desc = "clone";
        System.out.println(cloneTypeA);

        // 创建原型对象
        ConcretePrototypeB prototypeB = new ConcretePrototypeB("originalB");

        // 复制原型对象
        ConcretePrototypeB cloneTypeB = prototypeB.clone();
        System.out.println(cloneTypeB);
    }

}
