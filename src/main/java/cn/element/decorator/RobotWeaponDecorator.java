package cn.element.decorator;

public class RobotWeaponDecorator extends RobotDecorator {

    public RobotWeaponDecorator(Robot robot) {
        super(robot);
    }

    @Override
    public void doSomething() {

        super.doSomething();

        System.out.println("机器人武器强化");
    }
}
