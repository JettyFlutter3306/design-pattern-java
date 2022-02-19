package cn.element.pattern.singleton.common;

/**
 * 饿汉式单例写法在类加载时候就立即初始化,并且创建单例对象.
 * 它绝对线程安全,在线程还没出现时就实例化了
 * 不可能存在访问安全问题
 */
public class HungryStaticSingleton {

    private static final HungryStaticSingleton singleton;

    static {
        singleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {

    }

    public static HungryStaticSingleton getInstance() {
        return singleton;
    }
}
