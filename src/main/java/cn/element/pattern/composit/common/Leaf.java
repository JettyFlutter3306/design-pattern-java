package cn.element.pattern.composit.common;

public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public String operation() {
        return name;
    }

    @Override
    public Component addChild(Component component) {
        throw new UnsupportedOperationException("addChild not supported!");
    }

    @Override
    public Component removeChild(Component component) {
        throw new UnsupportedOperationException("removeChild not supported!");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("getChild not supported!");
    }
}
