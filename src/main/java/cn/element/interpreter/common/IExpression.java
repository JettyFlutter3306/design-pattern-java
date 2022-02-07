package cn.element.interpreter.common;

/**
 * 抽象表达式
 */
public interface IExpression {

    /**
     * 对表达式进行解析
     */
    Object interpret(Context context);
}
