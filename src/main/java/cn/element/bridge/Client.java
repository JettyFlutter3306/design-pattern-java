package cn.element.bridge;

/**
 * 设计模式之 桥接模式
 */
public class Client {

    public static void main(String[] args) {

        Handsome handsome = new Handsome();

        handsome.pursues(new Beauty());
    }
}
