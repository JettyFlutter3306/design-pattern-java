package cn.element.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib的简单使用
 */
public class CGLibProxy implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) {
        // 相当于JDK中的Proxy类,是完成代理的工具
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o, objects);
        after();

        return obj;
    }

    private void before() {
        System.out.println("我是媒婆,我要给你找对象,现在已经确认的你的需求");
        System.out.println("开始物色");
    }

    private void after() {
        System.out.println("双方同意,准备办婚事");
    }
}
