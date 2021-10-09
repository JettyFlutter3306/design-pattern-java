package cn.element.abstractfactory;

public class ModernFactory extends AbstractFactory {

    @Override
    public Food produceFood() {

        return new Bread();
    }

    @Override
    public Weapon produceWeapon() {

        return new Gun();
    }

    @Override
    public Vehicle produceVehicle() {

        return new Car();
    }
}
