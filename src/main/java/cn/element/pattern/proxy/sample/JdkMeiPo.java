package cn.element.pattern.proxy.sample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkMeiPo implements InvocationHandler {

    private IPerson target;

    public IPerson getInstance(IPerson target) {
        this.target = target;
        Class<? extends IPerson> clazz = target.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();

        return result;
    }

    private void before() {
        System.out.println("我是媒婆, 已经收集到你的需求, 开始物色.");
    }

    private void after() {
        System.out.println("双方同意,开始交往.");
    }
}
