package cn.element.memento.common;

/**
 * 备忘录管理者角色
 */
public class CareTaker {

    /**
     * 备忘录对象
     */
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void storeMemento(Memento memento) {
        this.memento = memento;
    }
}
