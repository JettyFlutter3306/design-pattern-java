package cn.element.observer;

public interface Debt {

    void borrow(CreditObserver credit);

    void notifyCreditors();

}
