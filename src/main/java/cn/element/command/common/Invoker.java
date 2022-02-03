package cn.element.command.common;

public class Invoker {

    private final ICommand command;

    public Invoker(ICommand command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
