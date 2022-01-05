package cn.element.command;

/**
 * 设计模式之命令模式
 * 多用于Transaction回滚
 */
public class Client {

    public static void main(String[] args) {

        Content content = new Content();

        Command insertCommand = new InsertCommand(content);
        insertCommand.doIt();
        insertCommand.undo();

        Command copyCommand = new CopyCommand(content);
        copyCommand.doIt();
        copyCommand.undo();
    }
}
