package cn.element.proxy.source;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用动态代理实现无感知数据源切换
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private final SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");

    private Object target;

    public IOrderService getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return (IOrderService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object object = method.invoke(target, args);
        after();

        return object;
    }

    private void before(Object target) {
        try {
            System.out.println("Proxy before method");
            Long time = (Long) target.getClass()
                                     .getMethod("getCreateTime")
                                     .invoke(target);
            int dbRouter = Integer.parseInt(yearFormatter.format(new Date(time)));

            System.out.println("静态代理类自动分配到[DB_" + dbRouter + "]数据源处理数据");

            DynamicDataSourceEntry.set(dbRouter);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void after() {
        System.out.println("Proxy after method.");
    }
}
