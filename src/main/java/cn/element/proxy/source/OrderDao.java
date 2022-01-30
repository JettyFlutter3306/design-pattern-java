package cn.element.proxy.source;

/**
 * 持久层操作类
 */
public class OrderDao {

    public int insert(Order order) {
        System.out.println("OrderDao创建Order成功!");
        return 1;
    }

}
