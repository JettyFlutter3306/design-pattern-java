package cn.element.composit;

public class Client {

    public static void main(String[] args) {

        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");

        Node c11 = new LeafNode("c11");
        Node c12 = new LeafNode("c12");
        BranchNode b21 = new BranchNode("section21");

        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        root.addNode(chapter1);
        root.addNode(chapter2);

        chapter1.addNode(c11);
        chapter1.addNode(c12);
        chapter2.addNode(b21);

        b21.addNode(c211);
        b21.addNode(c212);

        traverseTree(root, 0);
    }

    public static void traverseTree(Node root, int depth) {

        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }

        root.print();

        if (root instanceof BranchNode) {  //说明是树枝结点,还有子节点
            for (Node node : ((BranchNode) root).getNodes()) {  //循环递归子结点列表
                traverseTree(node, depth + 1);
            }
        }
    }
}
