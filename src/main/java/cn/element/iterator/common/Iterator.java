package cn.element.iterator.common;

/**
 * 抽象迭代器
 *
 * 迭代器(Iterator Pattern)又叫作游标模式(Cursor Pattern),它提供一种按顺序访问集合
 * 容器对象元素的方法,而又无须暴露集合内部表示.迭代器模式可以为不同的容器提供一致的
 * 遍历行为,而不用关心容器内元素的组成结构,属于行为型设计模式.
 */
public interface Iterator<E> {

    E next();

    boolean hasNext();
}
