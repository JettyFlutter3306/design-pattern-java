package cn.element.pattern.facade.common;

public class Client {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();
    }

}
