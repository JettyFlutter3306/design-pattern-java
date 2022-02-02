package cn.element.templatemethod.common;

/**
 * 抽象模板类
 */
public abstract class AbstractClass {

    protected void step1() {
        System.out.println("AbstractClass:step1");
    }

    protected void step2() {
        System.out.println("AbstractClass:step2");
    }

    protected void step3() {
        System.out.println("AbstractClass:step3");
    }

    /**
     * 声明为final类型的方法,避免子类对其复写
     */
    public final void templateMethod() {
        step1();
        step2();
        step3();
    }
}
