package cn.element.singleton;

/**
 * 懒汉式单例模式 加锁
 */
public class Manager04 {

    private static Manager04 INSTANCE;

    private Manager04() {

    }

    public static synchronized Manager04 getInstance() {

        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            INSTANCE = new Manager04();
        }

        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Manager04.getInstance().hashCode());
            }).start();
        }
    }
}
