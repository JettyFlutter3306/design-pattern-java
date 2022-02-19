package cn.element.pattern.proxy.source;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 切换数据源代理类
 */
public class OrderServiceStaticProxy implements IOrderService {

    private final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private final IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        int dbRouter = Integer.parseInt(yearFormat.format(new Date(time)));

        System.out.println("静态代理类自动分配到[DB_" + dbRouter + "]数据源处理数据");

        orderService.createOrder(order);
        DynamicDataSourceEntry.set(dbRouter);
        after();

        return 0;
    }

    private void before() {
        System.out.println("Proxy before method.");
    }

    private void after() {
        System.out.println("Proxy after method");
    }

}
