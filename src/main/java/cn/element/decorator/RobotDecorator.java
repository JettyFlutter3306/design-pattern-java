package cn.element.decorator;

public abstract class RobotDecorator extends Robot {

    protected Robot robot;

    public RobotDecorator(Robot robot) {

        this.robot = robot;
    }

    @Override
    public void doSomething() {

        robot.doSomething();
    }

}
