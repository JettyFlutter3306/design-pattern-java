package cn.element.pattern.command.bar;

/**
 * 暂停命令类
 */
public class PauseAction implements IAction {

    private final Player player;

    public PauseAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.pause();
    }
}
