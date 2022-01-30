package cn.element.proxy.generator;

import cn.element.proxy.sample.IPerson;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Medium implements MyInvocationHandler {

    private IPerson target;

    public IPerson getInstance(IPerson target) {
        this.target = target;
        Class<? extends IPerson> clazz = target.getClass();
        return (IPerson) IProxy.newProxyInstance(new IClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        before();
        Object result = method.invoke(target, args);
        after();

        return result;
    }

    private void before() {
        System.out.println("双方同意,开始交往.");
    }

    private void after() {
        System.out.println("我是媒婆,已经收集到你的需求,开始物色.");
    }
}
