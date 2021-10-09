package cn.element.factory;

public class Client {

    public static void main(String[] args) {

        Movable car = CarFactory.produceCar();

        car.go();

    }
}
