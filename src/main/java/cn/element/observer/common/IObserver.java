package cn.element.observer.common;

/**
 * 抽象观察者
 */
public interface IObserver<E>  {

    void update(E event);
}
