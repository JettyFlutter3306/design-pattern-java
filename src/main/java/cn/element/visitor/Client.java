package cn.element.visitor;

/**
 * 访问者模式适合用于结构固定的场景
 */
public class Client {

    public static void main(String[] args) {

        Visitor personVisitor = new PersonnelVisitor();
        Visitor corpVisitor = new CorpVisitor();

        Computer computer = new Computer();

        //针对不同访问者的不同实现
        computer.accept(personVisitor);
        computer.accept(corpVisitor);

    }
}
