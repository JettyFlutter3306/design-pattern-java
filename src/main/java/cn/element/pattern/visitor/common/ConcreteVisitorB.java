package cn.element.pattern.visitor.common;

public class ConcreteVisitorB implements IVisitor {

    @Override
    public void visit(ConcreteElementA elementA) {
        String result = elementA.operationA();
        System.out.println("result from " + elementA.getClass().getSimpleName() + ": " + result);
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        int result = elementB.operationB();
        System.out.println("result from " + elementB.getClass().getSimpleName() + ": " + result);
    }
}
