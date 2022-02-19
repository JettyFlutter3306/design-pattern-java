package cn.element.pattern.command.bar;

public class SpeedAction implements IAction {

    private final Player player;

    public SpeedAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.speed();
    }
}
