package cn.element.facade.api;

/**
 * 创建外观角色,对外只开放一个兑换礼物的exchange()方法,在exchange()方法内部整合
 * 3个子系统的所有功能
 */
public class GiftFacadeService {

    private final QualifyService qualifyService = new QualifyService();
    private final PaymentService paymentService = new PaymentService();
    private final ShippingService shippingService = new ShippingService();

    // 兑换
    public void exchange(GiftInfo giftInfo) {
        // 资格校验通过
        if (qualifyService.isAvailable(giftInfo)) {
            // 如果支付积分成功
            if (paymentService.pay(giftInfo)) {
                String shippingOrderNo = shippingService.delivery(giftInfo);
                System.out.println("物流系统下单成功,订单号是: " + shippingOrderNo);
            }
        }
    }
}
