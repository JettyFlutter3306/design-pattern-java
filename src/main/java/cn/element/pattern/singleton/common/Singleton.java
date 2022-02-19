package cn.element.pattern.singleton.common;

/**
 * 单例模式(Singleton Pattern)指确保一个类在任何情况下绝对只有一个实例,并提供一个全局访问点
 * 属于创建型设计模式
 *
 */
public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }
}
