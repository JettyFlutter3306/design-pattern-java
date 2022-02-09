package cn.element.visitor.common;

/**
 * 抽象元素
 */
public interface IElement {

    void accept(IVisitor visitor);

}
