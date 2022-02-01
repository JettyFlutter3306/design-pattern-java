package cn.element.delegate.common;

public class ConcreteB implements Task {

    @Override
    public void doTask() {
        System.out.println("执行,由B实现");
    }
}
