package cn.element.singleton.common;

public class LazyDoubleCheckSingleton {

    private static volatile LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton() {

    }

    public static LazyDoubleCheckSingleton getInstance() {
        // 检查是否要阻塞
        if (instance == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                // 检查是否重新创建实例
                if (instance == null) {
                    instance = new LazyDoubleCheckSingleton();
                    // 指定重排序的问题
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {

    }

}
