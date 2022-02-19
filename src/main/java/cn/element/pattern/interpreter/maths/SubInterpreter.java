package cn.element.pattern.interpreter.maths;

/**
 * 减法运算表达式
 */
public class SubInterpreter extends Interpreter {

    public SubInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}
