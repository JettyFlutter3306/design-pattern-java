package cn.element.interpreter.maths;

public class NumInterpreter implements IArithmeticInterpreter {

    private int value;

    public NumInterpreter(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}
