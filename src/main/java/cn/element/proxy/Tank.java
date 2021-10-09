package cn.element.proxy;

/**
 * 代理模式
 *      通常有静态代理和动态代理
 */
public class Tank implements Movable{

    public Tank() {

    }

    @Override
    public void move() {

        System.out.println("Tank's Moving......");
    }
}
