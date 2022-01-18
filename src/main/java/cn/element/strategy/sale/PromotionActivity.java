package cn.element.strategy.sale;

/**
 * 促销活动方案类
 */
public class PromotionActivity {

    private IPromotionStrategy strategy;

    public PromotionActivity(IPromotionStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.doPromotion();
    }
}
