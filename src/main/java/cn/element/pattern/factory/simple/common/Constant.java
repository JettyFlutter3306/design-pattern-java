package cn.element.pattern.factory.simple.common;

public enum Constant {

    PRODUCT_A(0),
    PRODUCT_B(1),
    PRODUCT_C(2);

    private final int code;

    Constant(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
