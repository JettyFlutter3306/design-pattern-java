package cn.element.composit.common;

public class Client {

    public static void main(String[] args) {
        // 创建一个根节点
        Component root = new Composite("root");

        // 创建一个树枝节点
        Component branchA = new Composite("---branchA");
        Component branchB = new Composite("------branchB");

        // 创建一个叶子节点
        Component leafA = new Leaf("------leafA");
        Component leafB = new Leaf("---------leafB");
        Component leafC = new Leaf("---leafC");

        root.addChild(branchA)
            .addChild(leafC);

        branchA.addChild(leafA)
               .addChild(branchB);

        branchB.addChild(leafB);

        System.out.println(root.operation());
    }
}
