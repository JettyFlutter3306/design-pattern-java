package cn.element.pattern.observer.mouse;

/**
 * 具体的被观察者
 */
public class Mouse extends EventContext {

    public void click() {
        System.out.println("调用单击方法");
        trigger(MouseEventType.ON_CLICK);
    }

    public void doubleClick() {
        System.out.println("调用双击方法");
        trigger(MouseEventType.ON_DOUBLE_CLICK);
    }

    public void up() {
        System.out.println("调用弹起方法");
        trigger(MouseEventType.ON_UP);
    }

    public void down() {
        System.out.println("调用按下方法");
        trigger(MouseEventType.ON_DOWN);
    }

    public void move() {
        System.out.println("调用移动方法");
        trigger(MouseEventType.ON_MOVE);
    }

    public void wheel() {
        System.out.println("调用滚动方法");
        trigger(MouseEventType.ON_WHEEL);
    }

    public void over() {
        System.out.println("调用悬停方法");
        trigger(MouseEventType.ON_OVER);
    }

    public void focus() {
        System.out.println("调用获得焦点方法");
        trigger(MouseEventType.ON_FOCUS);
    }

    public void blur() {
        System.out.println("调用失去焦点方法");
        trigger(MouseEventType.ON_BLUR);
    }

    @Override
    public String toString() {
        return "Mouse{鼠标}";
    }
}
