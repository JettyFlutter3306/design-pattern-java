package cn.element.pattern.decorator.overlay;

/**
 * 香肠装饰器
 */
public class SausageDecorator extends BatterCakeDecorator {

    public SausageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + " +1跟香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
