package cn.element.delegate.common;

/**
 * 具体任务角色A
 */
public class ConcreteA implements Task {

    @Override
    public void doTask() {
        System.out.println("执行,由A实现");
    }
}
