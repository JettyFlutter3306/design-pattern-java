package cn.element.pattern.command.common;

public class Ciient {

    public static void main(String[] args) {
        ICommand cmd = new ConcreteCommand();
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }

}
