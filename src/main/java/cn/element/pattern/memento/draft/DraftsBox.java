package cn.element.pattern.memento.draft;

import java.util.Stack;

/**
 * 备忘录管理角色类 草稿箱
 */
public class DraftsBox {

    private final Stack<ArticleMemento> STACK = new Stack<>();

    public ArticleMemento getMemento() {
        return STACK.pop();
    }

    public void addMemento(ArticleMemento articleMemento) {
        STACK.push(articleMemento);
    }

}
