package cn.element.pattern.delegate.common;

public class Client {

    public static void main(String[] args) {
        Task delegator = new Delegate();
        delegator.doTask();
    }

}
