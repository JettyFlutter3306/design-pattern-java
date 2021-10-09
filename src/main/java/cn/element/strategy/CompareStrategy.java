package cn.element.strategy;

import java.util.Comparator;

public interface CompareStrategy<T> extends Comparator<T> {

    int compare(T o1, T o2);


}
