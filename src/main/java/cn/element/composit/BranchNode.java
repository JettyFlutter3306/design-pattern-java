package cn.element.composit;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义树枝结点  树枝结点有后代
 */
public class BranchNode extends Node {

    private String content;

    private final List<Node> nodes;

    public BranchNode() {

        this.nodes = new ArrayList<>();
    }

    public BranchNode(String content) {

        this.nodes = new ArrayList<>();
        this.content = content;
    }

    @Override
    public void print() {

        System.out.println(content);
    }

    public void addNode(Node node) {

        this.nodes.add(node);
    }

    public List<Node> getNodes() {

        return nodes;
    }
}
