package cn.element.singleton;

/**
 * 饿汉式
 * 类加载到内存,就实例化一个单例对象,JVM保证线程安全
 * 简单实用,推荐使用
 * 唯一缺点,不论用到与否,类装载时就完成实例化
 */
public class Manager01 {

    private static final Manager01 INSTANCE = new Manager01();

    private Manager01() {

    }

    public static Manager01 getInstance() {

        return INSTANCE;
    }

    public static void main(String[] args) {

        Manager01 m1 = Manager01.getInstance();
        Manager01 m2 = Manager01.getInstance();

        System.out.println(m1 == m2);
    }

}
