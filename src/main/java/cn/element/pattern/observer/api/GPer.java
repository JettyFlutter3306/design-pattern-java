package cn.element.pattern.observer.api;

import java.util.Observable;

/**
 * 基于Java API实现通知机制
 * 使用java.util包下的 Observable 类
 */
public class GPer extends Observable {

    private final String name = "GPer生态圈";
    private static GPer per = null;

    private GPer() {

    }

    public static GPer getInstance() {
        if (per == null) {
            per = new GPer();
        }

        return per;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUsername() + "在" + name + "提交了一个问题!");

        setChanged();
        notifyObservers(question);
    }
}
