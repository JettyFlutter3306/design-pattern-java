package cn.element.composit.common;

/**
 * 组合模式(Composite Pattern) 又叫做整体-部分(Part-Whole)模式
 * 它的宗旨是通过将单个对象(叶子节点)和组合对象(树枝节点)用相同的接口进行表示
 * 使得客户对单个对象和组合对象的使用具有一致性,属于结构型设计模式
 */
public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract String operation();

    public abstract Component addChild(Component component);

    public abstract Component removeChild(Component component);

    public abstract Component getChild(int index);
}
