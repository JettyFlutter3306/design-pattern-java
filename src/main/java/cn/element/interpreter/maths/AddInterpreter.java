package cn.element.interpreter.maths;

/**
 * 加法运算表达式
 */
public class AddInterpreter extends Interpreter {

    public AddInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}
