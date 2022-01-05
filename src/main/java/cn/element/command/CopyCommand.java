package cn.element.command;

public class CopyCommand extends Command {

    public Content content;

    public CopyCommand(Content content) {
        this.content = content;
    }

    @Override
    public void doIt() {
        content.msg += content.msg;
    }

    @Override
    public void undo() {
        content.msg = content.msg.substring(0, content.msg.length() / 2);
    }
}
