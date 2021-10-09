package cn.element.abstractfactory;

public class Client {

    public static void main(String[] args) {

        AbstractFactory modernFactory = new ModernFactory();  //创建抽象工厂
        AbstractFactory magicFactory = new MagicFactory();

        Food bread = modernFactory.produceFood();
        bread.eat();

        Vehicle car = modernFactory.produceVehicle();
        car.go();

        Weapon gun = modernFactory.produceWeapon();
        gun.attack();



    }
}
