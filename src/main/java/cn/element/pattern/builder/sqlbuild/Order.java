package cn.element.pattern.builder.sqlbuild;

/**
 * SQL排序组件
 */
public class Order {

    private final boolean ascending; //升序还是降序
    private final String propertyName; //哪个字段升序，哪个字段降序

    public String toString() {
        return propertyName + ' ' + (ascending ? "asc" : "desc");
    }

    /**
     * Constructor for Order.
     */
    protected Order(String propertyName, boolean ascending) {
        this.propertyName = propertyName;
        this.ascending = ascending;
    }

    /**
     * Ascending order
     * @return Order
     */
    public static Order asc(String propertyName) {
        return new Order(propertyName, true);
    }

    /**
     * Descending order
     * @return Order
     */
    public static Order desc(String propertyName) {
        return new Order(propertyName, false);
    }

}

