package cn.element.proxy.aop;

import cn.element.proxy.Tank;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopDemo {

    /**
     * 动态代理分为两种，针对接口的动态代理和针对普通类的动态代理，
     * java中的动态代理是真的接口的动态代理，cglib是针对普通类的动态代理，
     * 目标javaEE的依赖包和Spring的jar包中已经包含了cglib相关jar包，因此即可以对代理也可以对普通类进行动态代理。
     *
     * 在<aop:config proxy-target-class="true"></aop:config>加上proxy-target-class="true"的一段即可
     * 其中proxy-target-class="true/false"属性，决定是基于接口的还是基于类的代理被创建。如果proxy-target-class 属性值被设置为true，
     * 那么基于类的代理将起作用(这时需要cglib库)。如果proxy-target-class属值被设置为false或者这个属性被省略，那么标准的JDK 基于接口的代理将起作用。
     * 即使你未声明 proxy-target-class="true" ，但运行类没有继承接口，spring也会自动使用CGLIB代理。
     * 高版本spring自动根据运行类选择 JDK 或 CGLIB 代理
     */
    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        ApplicationContext context = new ClassPathXmlApplicationContext("application-auto.xml");

        Tank tank = (Tank) context.getBean("tank2");

        tank.move();
    }
}
