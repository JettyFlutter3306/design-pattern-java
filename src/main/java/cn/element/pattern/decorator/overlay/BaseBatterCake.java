package cn.element.pattern.decorator.overlay;

/**
 * 基础煎饼套餐
 */
public class BaseBatterCake extends BatterCake {

    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
