package cn.element.pattern.mediator.common;

/**
 * 抽象中介者
 */
public abstract class Mediator {

    protected ConcreteColleagueA colleagueA;
    protected ConcreteColleagueB colleagueB;

    public void setColleagueA(ConcreteColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(ConcreteColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    // 中介者业务逻辑
    public abstract void transferA();

    public abstract void transferB();
}