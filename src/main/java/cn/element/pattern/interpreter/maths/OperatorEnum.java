package cn.element.pattern.interpreter.maths;

public enum OperatorEnum {

    LEFT_BRACKET("("),
    RIGHT_BRACKET(")"),
    SUB("-"),
    ADD("+"),
    MULTI("*"),
    DIV("/");

    private final String operator;

    public String getOperator() {
        return operator;
    }

    OperatorEnum(String operator) {
        this.operator = operator;
    }
}
