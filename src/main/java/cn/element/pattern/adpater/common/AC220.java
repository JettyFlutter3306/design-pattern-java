package cn.element.pattern.adpater.common;

/**
 * 适配器模式(Adapter Pattern)又叫作变压器模式,它的功能是将一个类的接口
 * 变成客户端所期望的另一种接口,从而使原本因接口不匹配而导致无法在一起
 * 工作的两个类能够在一起工作,属于结构型设计模式.
 */
public class AC220 {

    public int outputAC220V() {
        int output = 220;
        System.out.println("输出电压: " + output + "V");
        return output;
    }
}
