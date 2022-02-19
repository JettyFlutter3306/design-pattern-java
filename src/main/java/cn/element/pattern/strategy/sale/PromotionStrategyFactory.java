package cn.element.pattern.strategy.sale;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PromotionStrategyFactory {

    private final static Map<String, IPromotionStrategy> PROMOTION_MAP = new HashMap<>();

    static {
        PROMOTION_MAP.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTION_MAP.put(PromotionKey.CASHBACK, new CashbackStrategy());
        PROMOTION_MAP.put(PromotionKey.GROUP_BUY, new GroupBuyStrategy());
    }

    private static final IPromotionStrategy EMPTY = new EmptyStrategy();

    private PromotionStrategyFactory() {

    }

    public static IPromotionStrategy getPromotionStrategy(String promotionKey) {
        IPromotionStrategy strategy = PROMOTION_MAP.get(promotionKey);

        return strategy == null ? EMPTY : strategy;
    }

    private interface PromotionKey {
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUP_BUY = "GROUP_BUY";
    }

    public static Set<String> getPromotionKeys() {
        return PROMOTION_MAP.keySet();
    }
}
