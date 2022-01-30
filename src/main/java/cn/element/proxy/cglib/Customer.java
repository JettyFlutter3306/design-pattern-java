package cn.element.proxy.cglib;

/**
 * 单身客户类
 */
public class Customer {

    public void findLove() {
        System.out.println("符合要求");
    }

    public static void main(String[] args) {
        try {
            /*
            JDK采用的是读取接口的信息
            CGLib覆盖父类方法
            目的都是生成一个新类

            JDK Proxy对于用户而言,必须要有一个接口实现,目标类相对来说复杂
            CGLib可以代理任意一个普通的类,没有任何要求

            CGLib生成代理的逻辑更复杂,调用效率更高,生成一个包含了所有逻辑的FastClass,
            不再需要反射调用

            JDK Proxy生成代理的逻辑简单,执行效率相对要低,每次都要反射动态调用
            CGLib有一个缺点,不能代理final方法
             */
            Customer customer = (Customer) new CGLibProxy().getInstance(Customer.class);
            System.out.println(customer);
            customer.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
