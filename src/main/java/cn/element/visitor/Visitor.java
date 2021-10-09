package cn.element.visitor;

public interface Visitor {

    void visitCPU(CPU cpu);

    void visitMemory(Memory memory);

    void visitBoard(Board board);
}
