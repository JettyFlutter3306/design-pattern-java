package cn.element.decorator.common;

/**
 * 具体组件
 */
public class ConcreteComponent extends Component {

    /**
     * 相应的功能处理
     */
    @Override
    public void operation() {
        System.out.println("处理业务逻辑");
    }
}
