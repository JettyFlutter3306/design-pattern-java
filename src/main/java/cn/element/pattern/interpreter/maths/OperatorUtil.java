package cn.element.pattern.interpreter.maths;

import java.util.Stack;

public class OperatorUtil {

    public static boolean isOperator(String symbol) {
        return (symbol.equals("+") || symbol.equals("-") || symbol.equals("*"));
    }

    public static Interpreter getInterpreter(IArithmeticInterpreter left,
                                             IArithmeticInterpreter right,
                                             String symbol) {
        if ("+".equals(symbol)) {
            return new AddInterpreter(left, right);
        } else if ("-".equals(symbol)) {
            return new SubInterpreter(left, right);
        } else if ("*".equals(symbol)) {
            return new MultiInterpreter(left, right);
        } else if ("/".equals(symbol)) {
            return new DivInterpreter(left, right);
        }

        return null;
    }

    public static Interpreter getInterpreter(Stack<IArithmeticInterpreter> numStack,
                                             Stack<String> operatorStack) {
        IArithmeticInterpreter right = numStack.pop();
        IArithmeticInterpreter left = numStack.pop();

        String symbol = operatorStack.pop();
        System.out.println("数字出栈: " + right.interpret() + " , " + left.interpret() + ", 操作数出栈: " + symbol);

        if ("+".equals(symbol)) {
            return new AddInterpreter(left, right);
        } else if ("-".equals(symbol)) {
            return new SubInterpreter(left, right);
        } else if ("*".equals(symbol)) {
            return new MultiInterpreter(left, right);
        } else if ("/".equals(symbol)) {
            return new DivInterpreter(left, right);
        }

        return null;
    }

}
