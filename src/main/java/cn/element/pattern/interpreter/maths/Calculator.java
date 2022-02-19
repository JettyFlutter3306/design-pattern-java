package cn.element.pattern.interpreter.maths;

import java.util.Stack;

/**
 * 计算器类
 */
public class Calculator {

    /**
     * 数字栈
     */
    private final Stack<IArithmeticInterpreter> numStack = new Stack<>();

    /**
     * 操作符栈
     */
    private final Stack<String> operatorStack = new Stack<>();

    /**
     * 解析表达式
     */
    public Calculator(String expression) {
        parse(expression);
    }

    public void parse(String input) {
        // 对表达式去除空字符串操作
        String expression = format(input);
        System.out.println("标准表达式: " + expression);

        for (String s : expression.split(" ")) {
            if (s.length() == 0) {
                // 如果是空格,则继续循环,什么也不操作
                continue;

                // 如果是加减,因为加减的优先级最低,所以这里只要遇到加减号,无论操作栈中是什么运算符都要运算
            } else if (s.equals(OperatorEnum.ADD.getOperator()) || s.equals(OperatorEnum.SUB.getOperator())) {
                // 当栈不是空的,并且栈中最上面的一个元素是加减乘除的任意一个
                while (!operatorStack.empty()
                       && (operatorStack.peek().equals(OperatorEnum.SUB.getOperator())
                       || operatorStack.peek().equals(OperatorEnum.ADD.getOperator())
                       || operatorStack.peek().equals(OperatorEnum.MULTI.getOperator())
                       || operatorStack.peek().equals(OperatorEnum.DIV.getOperator()))) {
                    // 结果存入栈中
                    numStack.push(OperatorUtil.getInterpreter(numStack, operatorStack));
                }

                // 运算完成后将当前的运算符入栈
                System.out.println("操作符入栈: " + s);
                operatorStack.push(s);

                // 当前运算符是乘除的时候,因为优先级高于加减
                // 所以要判断最上面的是否是乘除,如果是乘除,则运算,否则直接入栈
            } else if (s.equals(OperatorEnum.MULTI.getOperator()) || s.equals(OperatorEnum.DIV.getOperator())) {
                while (!operatorStack.empty()
                       && (operatorStack.peek().equals(OperatorEnum.MULTI.getOperator())
                       || operatorStack.peek().equals(OperatorEnum.DIV.getOperator()))) {
                    numStack.push(OperatorUtil.getInterpreter(numStack, operatorStack));
                }

                // 将当前操作符入栈
                System.out.println("操作符入栈: " + s);
                operatorStack.push(s);

                // 如果是左括号,则直接入栈,什么也不用操作,trim()函数是用来去除空格的,由于上面的分割
                // 操作,可能会令操作带有空格
            } else if (s.equals(OperatorEnum.LEFT_BRACKET.getOperator())) {
                System.out.println("操作符入栈: " + s);
                operatorStack.push(OperatorEnum.LEFT_BRACKET.getOperator());

                // 如果是右括号,则清除栈中的运算符直至左括号
            } else if (s.equals(OperatorEnum.RIGHT_BRACKET.getOperator())) {
                while (!OperatorEnum.LEFT_BRACKET.getOperator().equals(operatorStack.peek())) {
                    // 开始运算
                    numStack.push(OperatorUtil.getInterpreter(numStack, operatorStack));
                }

                // 运算完成之后清除左括号
                String pop = operatorStack.pop();
                System.out.println("括号运算操作完成, 清除栈中右括号: " + pop);

                // 如果是数字,则直接入数据的栈
            } else {
                // 将数字字符串转换成数字,然后存入栈中
                NumInterpreter numInterpreter = new NumInterpreter(Integer.parseInt(s));
                System.out.println("数字入栈: " + s);
                numStack.push(numInterpreter);
            }
        }

        // 最后当栈中不是空的时候继续运算,直到栈为空即可
        while (!operatorStack.empty()) {
            numStack.push(OperatorUtil.getInterpreter(numStack, operatorStack));
        }
    }

    /**
     * 计算结果出栈
     */
    public int calculate() {
        return numStack.pop().interpret();
    }

    private String format(String expression) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == ')' ||
                    expression.charAt(i) == '+' || expression.charAt(i) == '-' ||
                    expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                // 在操作符与数字之间增加一个空格
                result.append(" ").append(expression.charAt(i)).append(" ");
            } else {
                result.append(expression.charAt(i));
            }
        }

        return result.toString();
    }
}
