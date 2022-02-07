package cn.element.interpreter.common;

import java.util.Stack;

public class Client {

    public static void main(String[] args) {
        Context context = new Context();

        // 定义个语法容器, 用于存储一个具体表达式
        Stack<IExpression> stack = new Stack<>();

        // 省略递归调用逻辑

        // 获取最终的解析表达式,完整语法树
        IExpression expression = stack.pop();

        // 递归调用获取结果
        expression.interpret(context);
    }

}
