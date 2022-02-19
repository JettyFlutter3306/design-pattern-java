package cn.element.pattern.delegate.common;

import java.util.Random;

public class Delegate implements Task {

    @Override
    public void doTask() {
        System.out.println("代理执行开始");

        Task task;

        if (new Random().nextBoolean()) {
            task = new ConcreteA();
            task.doTask();
        } else {
            task = new ConcreteB();
            task.doTask();
        }

        System.out.println("代理任务执行完毕");
    }
}
