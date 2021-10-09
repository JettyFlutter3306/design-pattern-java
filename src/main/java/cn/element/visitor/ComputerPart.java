package cn.element.visitor;

public abstract class ComputerPart {

    abstract void accept(Visitor v);

    abstract double getPrice();
}
