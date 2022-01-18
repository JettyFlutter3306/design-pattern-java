package cn.element.strategy.sale;

/**
 * 拼团优惠策略
 */
public class GroupBuyStrategy implements IPromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("5人成团, 可以优惠~");
    }
}
