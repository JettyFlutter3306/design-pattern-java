package cn.element.pattern.composit.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝节点
 */
public class Composite extends Component {

    private final List<Component> components;

    public Composite(String name) {
        super(name);
        this.components = new ArrayList<>();
    }

    @Override
    public String operation() {
        StringBuilder builder = new StringBuilder(name);

        for (Component component : components) {
            builder.append("\n");
            builder.append(component.operation());
        }

        return builder.toString();
    }

    @Override
    public Component addChild(Component component) {
        components.add(component);
        return this;
    }

    @Override
    public Component removeChild(Component component) {
        components.remove(component);
        return this;
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }
}
