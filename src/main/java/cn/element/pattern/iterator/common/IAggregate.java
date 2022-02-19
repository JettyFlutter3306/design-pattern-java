package cn.element.pattern.iterator.common;

/**
 * 抽象容器
 */
public interface IAggregate<E> {

    boolean add(E element);

    boolean remove(E element);

    Iterator<E> iterator();
}
