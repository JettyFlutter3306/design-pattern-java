package cn.element.proxy.generator;

import cn.element.proxy.sample.IPerson;
import cn.element.proxy.sample.ZhangSan;

public class Client {

    public static void main(String[] args) {
        Medium medium = new Medium();
        IPerson zhangSan = medium.getInstance(new ZhangSan());
        zhangSan.findLove();
    }
}
