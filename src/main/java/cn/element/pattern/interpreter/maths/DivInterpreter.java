package cn.element.pattern.interpreter.maths;

/**
 * 除法运算表达式
 */
public class DivInterpreter extends Interpreter {

    public DivInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() / right.interpret();
    }
}
