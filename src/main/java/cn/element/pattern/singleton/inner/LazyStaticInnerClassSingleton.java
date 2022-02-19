package cn.element.pattern.singleton.inner;

import java.lang.reflect.Constructor;

/**
 * 静态内部类写法
 * 这种形式兼顾饿汉式单例写法的内存浪费问题和synchronized的性能问题
 * 完美地屏蔽了这两个缺点
 */
public class LazyStaticInnerClassSingleton {

    /**
     * 使用LazyInnerClassGeneral的时候,默认会先初始化内部类
     * 如果没有使用,则内部类是不加载的
     */
    private LazyStaticInnerClassSingleton() {
        if (LazyHolder.INSTANCE != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    /**
     * 每一个关键字都不是多余的,static是为了使单例模式的空间共享,保证这个方法不会被重写,重载
     */
    private static LazyStaticInnerClassSingleton getInstance() {
        // 在返回结果之前,一定会先加载内部类
        return LazyHolder.INSTANCE;
    }

    /**
     * 利用了Java本身的语法特点,默认不加载内部类
     */
    private static class LazyHolder {
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }

    public static void main(String[] args) {
        // 还原反射破坏单例模式的翻车现场
        try {
            // 如果有人耳恶意使用反射破坏
            Class<LazyStaticInnerClassSingleton> clazz = LazyStaticInnerClassSingleton.class;

            //通过反射获取私有方法
            Constructor<LazyStaticInnerClassSingleton> constructor = clazz.getDeclaredConstructor();

            // 强制访问
            constructor.setAccessible(true);

            // 暴力初始化
            Object o1 = constructor.newInstance();


            // 调用了两次构造方法,相当于 new 了两次,犯了原则性错误
            Object o2 = constructor.newInstance();

            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
