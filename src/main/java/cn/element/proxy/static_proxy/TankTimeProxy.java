package cn.element.proxy.static_proxy;

import cn.element.proxy.Movable;

import java.util.Random;

/**
 * 实现对Tank类的静态代理
 * 实现共同的Movable接口就可以实现不同的静态代理之间的嵌套
 * 类似于装饰者模式
 */
public class TankTimeProxy implements Movable {

    private final Movable tankProxy;

    public TankTimeProxy(Movable tankProxy) {
        this.tankProxy = tankProxy;
    }

    @Override
    public void move() {

        long start = System.currentTimeMillis();

        tankProxy.move();

        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

}
