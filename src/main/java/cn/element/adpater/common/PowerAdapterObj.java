package cn.element.adpater.common;

/**
 * 对象适配器的通用写法
 * 对象适配器的原理就是通过组合来实现适配器功能,具体做法就是首先让Adapter实现ITarget接口
 * 然后内部持有Adapter实例,最后在ITarget接口规定的方法内转换Adapter
 */
public class PowerAdapterObj implements DC5 {

    private final AC220 ac220;

    public PowerAdapterObj(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5V() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput / 44;

        System.out.println("使用Adapter输入: AC" + adapterInput + "V, 输出: DC" + adapterOutput + "V");

        return adapterOutput;
    }
}
