package cn.element.abstractfactory;

import cn.element.factory.Broom;

public class MagicFactory extends AbstractFactory {

    @Override
    public Food produceFood() {

        return new MushRoom();
    }

    @Override
    public Weapon produceWeapon() {

        return new MagicStick();
    }

    @Override
    public Vehicle produceVehicle() {

        return new Broom();
    }
}
