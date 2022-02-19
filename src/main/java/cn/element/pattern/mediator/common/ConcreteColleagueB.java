package cn.element.pattern.mediator.common;

public class ConcreteColleagueB extends Colleague {

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
        mediator.setColleagueB(this);
    }

    public void selfMethodB() {
        System.out.println(getClass().getSimpleName() + ".self-Method");
    }

    public void depMethodB() {
        System.out.println(getClass().getSimpleName() + ":depMethod:delegate to Mediator");
        mediator.transferB();
    }
}
