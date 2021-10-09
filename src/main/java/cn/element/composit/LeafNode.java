package cn.element.composit;

/**
 * 定义叶子结点 叶子结点没有后代
 */
public class LeafNode extends Node {

    private final String content;

    public LeafNode(String content) {

        this.content = content;
    }

    @Override
    public void print() {

        System.out.println(content);
    }
}
