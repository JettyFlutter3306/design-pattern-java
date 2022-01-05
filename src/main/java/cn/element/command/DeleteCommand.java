package cn.element.command;

public class DeleteCommand extends Command {

    public Content content;

    public String deleted;

    public DeleteCommand(Content content) {
        this.content = content;
    }

    @Override
    public void doIt() {
        deleted = content.msg.substring(0, 5);
        content.msg = content.msg.substring(5);
    }

    @Override
    public void undo() {
        content.msg = deleted + content.msg;
    }
}
