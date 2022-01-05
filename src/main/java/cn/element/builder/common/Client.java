package cn.element.builder.common;

/**
 * 建造者模式通用写法
 */
public class Client {

    public static void main(String[] args) {
        IBuilder builder = new ConcreteBuilder();

        System.out.println(builder.build());
    }
}
