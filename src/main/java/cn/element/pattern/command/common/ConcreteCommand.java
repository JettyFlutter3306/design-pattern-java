package cn.element.pattern.command.common;

public class ConcreteCommand implements ICommand {

    /**
     * 直接创建接收者,不暴露给客户端
     */
    private final Receiver receiver = new Receiver();

    @Override
    public void execute() {
        receiver.action();
    }
}
