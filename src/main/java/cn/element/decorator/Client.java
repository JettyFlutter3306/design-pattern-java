package cn.element.decorator;

public class Client {

    public static void main(String[] args) {

        Robot robot = new FirstRobot();

        RobotDecorator weaponDecorator = new RobotWeaponDecorator(robot);
        weaponDecorator.doSomething();

        System.out.println("====================");

        RobotDecorator armorDecorator = new RobotArmorDecorator(weaponDecorator);
        armorDecorator.doSomething();

    }
}
