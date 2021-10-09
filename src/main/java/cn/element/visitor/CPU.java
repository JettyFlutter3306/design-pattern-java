package cn.element.visitor;

public class CPU extends ComputerPart {

    @Override
    void accept(Visitor v) {
        v.visitCPU(this);
    }

    @Override
    double getPrice() {
        return 900;
    }
}
