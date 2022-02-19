package cn.element.pattern.proxy.sample;

public class Client {

    public static void main(String[] args) {
        ZhangLaoSan zhangLaoSan = new ZhangLaoSan(new ZhangSan());
        zhangLaoSan.findLove();

        JdkMeiPo jdkMeiPo = new JdkMeiPo();
        IPerson zhaoLiuProxy = jdkMeiPo.getInstance(new ZhaoLiu());
        zhaoLiuProxy.findLove();
    }

}
