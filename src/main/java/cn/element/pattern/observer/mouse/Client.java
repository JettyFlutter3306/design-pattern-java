package cn.element.pattern.observer.mouse;

public class Client {

    public static void main(String[] args) {
        EventListener listener = new MouseEventListener();

        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK, listener);
        mouse.addListener(MouseEventType.ON_MOVE, listener);

        mouse.click();
        mouse.move();
    }
}
