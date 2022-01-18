package cn.element.strategy.sale;

import java.util.Set;

public class Client {

    public static void main(String[] args) {
        PromotionActivity activity618 = new PromotionActivity(new CouponStrategy());
        PromotionActivity activity1111 = new PromotionActivity(new CashbackStrategy());

        activity618.execute();
        activity1111.execute();

        Set<String> set = PromotionStrategyFactory.getPromotionKeys();
        String promotionKey = "COUPON";

        IPromotionStrategy strategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);
        strategy.doPromotion();
    }
}
