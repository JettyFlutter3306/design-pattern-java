package cn.element.pattern.facade.api;

/**
 * 物流系统
 */
public class ShippingService {

    public String delivery(GiftInfo giftInfo) {
        System.out.println(giftInfo.getName() + "进入物流系统");
        String shippingOrderNo = "666";
        return shippingOrderNo;
    }
}
