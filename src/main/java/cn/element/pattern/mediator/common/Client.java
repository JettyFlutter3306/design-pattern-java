package cn.element.pattern.mediator.common;

public class Client {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);

        colleagueA.depMethodA();
        System.out.println("===========================");
        colleagueB.depMethodB();
    }

}
