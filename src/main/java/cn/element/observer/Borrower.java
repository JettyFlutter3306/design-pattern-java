package cn.element.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 借款人 被观察者
 */
public class Borrower implements Debt {

    private final List<CreditObserver> list;

    public Borrower() {

        this.list = new ArrayList<>();
    }

    /**
     * 添加观察者
     * @param credit  被借款方  观察者
     */
    @Override
    public void borrow(CreditObserver credit) {

        this.list.add(credit);
    }

    @Override
    public void notifyCreditors() {

        list.forEach(CreditObserver::takeMoney);  //调用观察者的事件处理方法
    }
}
