package cn.element.pattern.proxy.generator;

import cn.element.pattern.proxy.sample.IPerson;
import cn.element.pattern.proxy.sample.ZhangSan;

public class Client {

    public static void main(String[] args) {
        Medium medium = new Medium();
        IPerson zhangSan = medium.getInstance(new ZhangSan());
        zhangSan.findLove();
    }
}
