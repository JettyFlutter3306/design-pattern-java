package cn.element.singleton;

/**
 * 懒汉式 线程安全并且提高性能
 */
public class Manager05 {

    private static volatile Manager05 INSTANCE;

    private Manager05() {

    }

    public static Manager05 getInstance() {

        if (INSTANCE == null) {
            synchronized (Manager05.class) {  //进行双重检查
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    INSTANCE = new Manager05();
                }
            }
        }

        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Manager05.getInstance().hashCode());
            }).start();
        }
    }
}
