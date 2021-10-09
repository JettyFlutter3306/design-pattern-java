package cn.element.proxy.static_proxy;

import cn.element.proxy.Movable;

public class TankLogProxy implements Movable {

    private final Movable tankProxy;

    public TankLogProxy(Movable tankProxy) {
        this.tankProxy = tankProxy;
    }

    @Override
    public void move() {

        System.out.println("Tank starts moving ... ...");

        tankProxy.move();

        System.out.println("Tank destroyed , stopping moving ... ...");
    }
}
