package cn.element.proxy.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeProxy {

    private long past;

    public TimeProxy() {

    }

    @Before("execution(void cn.element.proxy.Tank.move())")
    public void before() {

        System.out.println("method started ");

        past = System.currentTimeMillis();
    }

    @After("execution(void cn.element.proxy.Tank.move())")
    public void after() {

        System.out.println("method ended ");

        System.out.println("运行时间: " + (System.currentTimeMillis() - past) + "ms");
    }
}
