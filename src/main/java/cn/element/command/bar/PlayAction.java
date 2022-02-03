package cn.element.command.bar;

public class PlayAction implements IAction {

    private final Player player;

    public PlayAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
}
