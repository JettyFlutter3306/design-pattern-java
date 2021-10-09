package cn.element.strategy;

import java.util.Arrays;

public class Context<T> {

    public void sort(T[] arr, CompareStrategy<T> compareStrategy) {

        Arrays.sort(arr, compareStrategy);
    }
}
