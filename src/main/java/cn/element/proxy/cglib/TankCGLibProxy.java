package cn.element.proxy.cglib;

import cn.element.proxy.Tank;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 使用Cglib实现动态代理
 */
public class TankCGLibProxy {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {  //设置回调函数
            System.out.println("before");

            Object result = methodProxy.invokeSuper(o, objects);

            System.out.println("after");

            return result;
        });

        Tank tankProxy = (Tank) enhancer.create();
        tankProxy.move();
    }
}
