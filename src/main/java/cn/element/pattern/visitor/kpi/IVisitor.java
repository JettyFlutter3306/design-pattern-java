package cn.element.pattern.visitor.kpi;

public interface IVisitor {

    void visit(Engineer engineer);

    void visit(Manager manager);
}
