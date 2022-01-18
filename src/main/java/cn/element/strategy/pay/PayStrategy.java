package cn.element.strategy.pay;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付策略管理
 */
public class PayStrategy {

    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JDPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String DEFAULT_PAY = "AliPay";

    private static final Map<String, Payment> strategy = new HashMap<>();

    static {
        strategy.put(ALI_PAY, new AliPay());
        strategy.put(JD_PAY, new JDPay());
        strategy.put(WECHAT_PAY, new WechatPay());
        strategy.put(UNION_PAY, new UnionPay());
    }

    public static Payment get(String payKey) {
        if (!strategy.containsKey(payKey)) {
            return strategy.get(DEFAULT_PAY);
        }

        return strategy.get(payKey);
    }
}
