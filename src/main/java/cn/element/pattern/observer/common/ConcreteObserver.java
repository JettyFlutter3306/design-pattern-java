package cn.element.pattern.observer.common;

/**
 * 具体观察者
 */
public class ConcreteObserver<E> implements IObserver<E> {

    @Override
    public void update(E event) {
        System.out.println("receive event: " + event);
    }
}
