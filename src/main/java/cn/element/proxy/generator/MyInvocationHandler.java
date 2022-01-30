package cn.element.proxy.generator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface MyInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
}
