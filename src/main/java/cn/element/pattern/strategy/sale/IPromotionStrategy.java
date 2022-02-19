package cn.element.pattern.strategy.sale;

/**
 * 使用策略模式实现促销优惠方案选择
 *
 * 促销策略抽象
 */
public interface IPromotionStrategy {

    void doPromotion();
}
