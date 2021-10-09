package cn.element.proxy;

import cn.element.proxy.static_proxy.TankLogProxy;
import cn.element.proxy.static_proxy.TankTimeProxy;

public class Client {

    public static void main(String[] args) {

        new TankLogProxy(new TankTimeProxy(new Tank())).move();  //嵌套类似于装饰模式

        System.out.println("============================");



    }
}
