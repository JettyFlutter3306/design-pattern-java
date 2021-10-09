package cn.element.singleton;

/**
 * 枚举单例
 * 不仅可以解决线程安全问题 还可以防止反序列化
 */
public enum Manager07 {

    INSTANCE;

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Manager07.INSTANCE.hashCode());
            }).start();
        }
    }
}
