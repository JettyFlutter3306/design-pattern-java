package cn.element.mediator.common;

/**
 * 具体中介者
 */
public class ConcreteMediator extends Mediator {

    @Override
    public void transferA() {
        // 协调行为: A转发到B
        colleagueB.selfMethodB();
    }

    @Override
    public void transferB() {
        // 协调行为: B转发到A
        colleagueA.selfMethodA();
    }
}
