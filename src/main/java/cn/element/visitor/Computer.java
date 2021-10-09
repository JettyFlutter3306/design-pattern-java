package cn.element.visitor;

/**
 * 访问者模式
 */
public class Computer {

    private ComputerPart cpu = new CPU();
    private ComputerPart memory = new Memory();
    private ComputerPart board = new Board();

    public void accept(Visitor v) {

        this.cpu.accept(v);
        this.memory.accept(v);
        this.board.accept(v);
    }







}
