package cn.element.iterator;

import java.util.Iterator;

/**
 * 设计模式之 迭代器模式
 */
public class IArrayList<T> implements Iterable<T> {

    protected Object[] array;

    private int n;

    public IArrayList() {

        this.array = new Object[10];
        this.n = 0;
    }

    public int add(T element) {

        if (this.n == this.array.length) {
            Object[] newArray = new Object[(int) (this.n * 1.5)];

            System.arraycopy(this.array, 0, newArray, 0, this.n);

            this.array = newArray;

        }

        this.array[this.n] = element;
        this.n++;

        return this.n - 1;
    }

    public int size() {
        return this.n;
    }

    private class ArrayIterator implements Iterator<T> {

        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < IArrayList.this.n;
        }

        @Override
        public T next() {
            return (T) IArrayList.this.array[cursor++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }


}
