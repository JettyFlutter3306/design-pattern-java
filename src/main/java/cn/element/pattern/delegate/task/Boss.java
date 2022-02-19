package cn.element.pattern.delegate.task;

/**
 * 老板类
 */
public class Boss {

    public void command(String task, Leader leader) {
        leader.doing(task);
    }

}
