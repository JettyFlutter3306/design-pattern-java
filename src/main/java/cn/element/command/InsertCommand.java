package cn.element.command;

public class InsertCommand extends Command {

    public Content content;

    public String strToInsert = "http://www.mashibing.com";

    public InsertCommand(Content content) {
        this.content = content;
    }

    @Override
    public void doIt() {
        content.msg += strToInsert;
    }

    @Override
    public void undo() {
        content.msg = content.msg.substring(0, content.msg.length() - strToInsert.length());
    }
}
