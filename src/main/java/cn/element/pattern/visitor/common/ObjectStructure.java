package cn.element.pattern.visitor.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 结构对象
 */
public class ObjectStructure {

    private final List<IElement> list = new ArrayList<>();

    {
        list.add(new ConcreteElementA());
        list.add(new ConcreteElementB());
    }

    public void accept(IVisitor visitor) {
        for (IElement element : list) {
            element.accept(visitor);
        }
    }

}
