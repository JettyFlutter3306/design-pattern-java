package cn.element.pattern.facade.common;

/**
 * 外观角色
 *
 * 门面模式(Facade Pattern)又叫作外观模式,提供了一个统一的接口,用来访问子系统中的
 * 一群接口.其主要特征是定义了一个高层接口,让子系统更容易使用,属于结构型设计模式.
 */
public class Facade {

    private final SubSystemA a = new SubSystemA();
    private final SubSystemB b = new SubSystemB();
    private final SubSystemC c = new SubSystemC();

    /**
     * 对外接口
     */
    public void doA() {
        a.doA();
    }

    public void doB() {
        b.doB();
    }

    public void doC() {
        c.doC();
    }

}
