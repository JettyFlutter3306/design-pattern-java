package cn.element.factory;

/**
 * 简单工厂的扩展性不太好
 */
public class SimpleVehicleFactory {

    public Car produceCar() {

        return new Car();
    }

    public Broom produceBroom() {

        return new Broom();
    }

    public Plane producePlane() {

        return new Plane();
    }
}
