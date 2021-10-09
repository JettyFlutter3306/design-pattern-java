package cn.element.iterator;

import java.util.Iterator;

public class Client {

    public static void main(String[] args) {

        IArrayList<Integer> list = new IArrayList<>();

        Integer[] value = new Integer[]{1,3,4,6,8,9,0,21};

        for (Integer i : value) {
            System.out.print(list.add(i) + "\t");
        }

        System.out.println();
        System.out.println("========================");

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }


    }
}
