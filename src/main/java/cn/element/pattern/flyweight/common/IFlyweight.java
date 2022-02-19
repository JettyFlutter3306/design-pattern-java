package cn.element.pattern.flyweight.common;

/**
 * 享元模式(Flyweight Pattern): 又叫做轻量级模式,是对象池的一种实现
 * 类似线程池,线程池可以避免不停地创建和销毁对象,消耗性能.享元模式
 * 提供了减少对象数量从而改善应用所需对象结构的方式.其宗旨是共享细粒度对象
 * 将多个对同一对象的访问集中起来,不必为每个访问者都创建一个对象,以此来降低内存
 * 的消耗,属于结构性设计模式
 * 享元模式为工厂方法模式增加了缓存这一功能
 * (1) 常用语系统底层的开发,以便解决的性能的问题
 * (2) 系统有大量的相似对象,需要缓冲池的场景
 */
public interface IFlyweight {

    void operation(String extrinsicState);
}
