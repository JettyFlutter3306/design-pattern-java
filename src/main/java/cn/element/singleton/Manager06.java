package cn.element.singleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类 这样可以实现懒加载
 */
public class Manager06 {

    private Manager06() {

    }

    private static class Manager06Holder {

        private final static Manager06 INSTANCE = new Manager06();
    }

    public static Manager06 getInstance() {

        return Manager06Holder.INSTANCE;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Manager06.getInstance().hashCode());
            }).start();
        }
    }

}
