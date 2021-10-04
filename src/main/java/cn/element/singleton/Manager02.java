package cn.element.singleton;

/**
 * 使用静态语句块
 * 和 01 没有什么区别
 */
public class Manager02 {

    private static final Manager02 INSTANCE;

    static {
        INSTANCE = new Manager02();
    }

    private Manager02() {

    }

    public static Manager02 getInstance() {

        return INSTANCE;
    }
}
