package cn.element.facade.api;

/**
 * 支付系统
 */
public class PaymentService {

    public boolean pay(GiftInfo giftInfo) {
        System.out.println("支付" + giftInfo.getName() + "积分成功");
        return true;
    }
}
