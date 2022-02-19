package cn.element.pattern.adpater.common;

public class PowerAdapterInterface implements DC {

    private final AC220 ac220;

    public PowerAdapterInterface(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5V() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput / 44;

        System.out.println("使用Adapter输入: AC" + adapterInput + "V, 输出: DC" + adapterOutput + "V");

        return adapterOutput;
    }

    @Override
    public int output12V() {
        return 0;
    }

    @Override
    public int output24V() {
        return 0;
    }

    @Override
    public int output36V() {
        return 0;
    }
}
