package cn.element.proxy.dynamic;

import cn.element.proxy.Movable;
import cn.element.proxy.Tank;

import java.lang.reflect.Proxy;

public class TankDynamicProxy {

    public static void main(String[] args) {

        Tank tank = new Tank();

//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        Movable tankProxy = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, (proxy, method, args1) -> {
            System.out.println("method:" + method.getName() + " activated");

            Object o = method.invoke(tank, args1);

            System.out.println("method:" + method.getName() + " ended");

            return o;
        });

        tankProxy.move();
    }
}
