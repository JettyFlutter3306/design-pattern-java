package cn.element.facade.api;

/**
 * 使用门面模式整合已知API的功能
 *
 * 礼品的实体类
 */
public class GiftInfo {

    private final String name;

    public GiftInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
