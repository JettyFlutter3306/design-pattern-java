package cn.element.strategy.common;

/**
 * 策略模式(Strategy Pattern)又叫做政策模式(Policy Pattern)
 * 它将定义的算法家族分别封装起来,让他们之间可以互相替换,从而让算法
 * 的变化不会影响到使用算法的用户,属于行为型设计模式
 *
 * 策略模式使用的就是面向对象的继承和多态,从而实现统一行为在不同的场景下具备不同的实现
 *
 * 抽象策略类
 */
public interface IStrategy {

    void algorithm();

}
