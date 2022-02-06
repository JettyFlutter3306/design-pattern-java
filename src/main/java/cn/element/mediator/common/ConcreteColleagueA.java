package cn.element.mediator.common;

public class ConcreteColleagueA extends Colleague {

    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
        mediator.setColleagueA(this);
    }

    /**
     * 自发行为: Self-Method
     */
    public void selfMethodA() {
        // 处理自己的逻辑
        System.out.println(getClass().getSimpleName() + ".self-Method");
    }

    /**
     * 依赖方法: Dep-Method
     */
    public void depMethodA() {
        // 处理自己的逻辑
        System.out.println(getClass().getSimpleName() + ":depMethod:delegate to Mediator");

        // 无法处理的业务逻辑委托给中介者处理
        mediator.transferA();
    }


}
