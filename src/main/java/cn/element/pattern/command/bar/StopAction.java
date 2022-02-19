package cn.element.pattern.command.bar;

public class StopAction implements IAction {

    private final Player player;

    public StopAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.stop();
    }
}
