package cn.element.strategy.pay;

public class Client {

    public static void main(String[] args) {
        Order order = new Order("1", "2020031401000323", 324.5);
        System.out.println(order.pay(PayStrategy.ALI_PAY));
    }
}
