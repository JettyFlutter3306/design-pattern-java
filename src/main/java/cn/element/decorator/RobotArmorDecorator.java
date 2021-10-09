package cn.element.decorator;

public class RobotArmorDecorator extends RobotDecorator {

    public RobotArmorDecorator(Robot robot) {
        super(robot);
    }

    @Override
    public void doSomething() {

        super.doSomething();

        System.out.println("机器人防御强化");
    }
}
