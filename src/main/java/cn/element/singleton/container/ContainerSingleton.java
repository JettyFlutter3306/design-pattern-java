package cn.element.singleton.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用容器式单例模式解决大规模生产单例问题
 * 容器式单例写法适用于需要大量创建单例对象的场景,便于管理
 * 但是它是非线程安全的
 */
public class ContainerSingleton {

    private ContainerSingleton() {

    }

    private static final Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String className) {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;

                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }

}
