package cn.element.pattern.strategy.pay;

/**
 * 订单类
 */
public class Order {

    private final String uid;
    private final String orderId;
    private final double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public MsgResult pay() {
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public MsgResult pay(String payKey) {
        Payment payment = PayStrategy.get(payKey);
        System.out.println("本次使用: " + payment.getName());
        System.out.println("本次交易金额为: " + amount + ", 开始扣款");

        return payment.pay(uid, amount);
    }
}
