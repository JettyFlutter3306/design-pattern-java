package cn.element.observer.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题者
 */
public class ConcreteSubject<E> implements ISubject<E> {

    private final List<IObserver<E>> observers = new ArrayList<>();

    @Override
    public boolean attach(IObserver<E> observer) {
        if (observers.contains(observer)) {
            return false;
        }

        return observers.add(observer);
    }

    @Override
    public boolean detach(IObserver<E> observer) {
        return observers.remove(observer);
    }

    @Override
    public void notify(E event) {
        for (IObserver<E> observer : observers) {
            observer.update(event);
        }
    }
}
