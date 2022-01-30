package cn.element.proxy.source;

public class OrderService implements IOrderService {

    private final OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用OrderDap创建订单");
        return orderDao.insert(order);
    }
}
