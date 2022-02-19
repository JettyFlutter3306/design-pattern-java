package cn.element.pattern.command.bar;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制条类
 */
public class Controller {

    private final List<IAction> actions = new ArrayList<>();

    public void addAction(IAction action) {
        actions.add(action);
    }

    public void execute(IAction action) {
        action.execute();
    }

    public void executes() {
        for (IAction action : actions) {
            action.execute();
        }

        actions.clear();
    }
}
