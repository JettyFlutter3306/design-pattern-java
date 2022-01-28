package cn.element.singleton.common;

/**
 * 懒汉式写法特点是单例对象在被使用时才会被初始化
 * 懒汉式写法会产生线程安全问题
 * 因为两个线程可能会同时进入 if () 代码块,这时两个线程都满足条件 lazy == null
 * 然后就会创建两个对象,加上synchronized关键字就可以完美解决问题
 */
public class LazySimpleSingleton {

    private LazySimpleSingleton() {

    }

    private static LazySimpleSingleton lazy = null;

    public static synchronized LazySimpleSingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySimpleSingleton();
        }

        return lazy;
    }

    public static void main(String[] args) {
        // 多次运行这段代码会发现打印的内存地址不一样
        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());

        t1.start();
        t2.start();
    }
}
