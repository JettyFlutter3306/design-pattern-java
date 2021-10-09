package cn.element.strategy;


import java.util.Arrays;

public class Client {

    public static void main(String[] args) {

        Cat[] cats = new Cat[]{
                new Cat(10, 7),
                new Cat(8, 1),
                new Cat(19, 2),
                new Cat(2, 90),
                new Cat(6, 80),
        };

        Context<Cat> context = new Context<>();  //创建上下文

//        context.sort(cats, new HeightCompareStrategy());
//        System.out.println(Arrays.toString(cats));

        context.sort(cats, new WeightCompareStrategy());
        System.out.println(Arrays.toString(cats));

    }
}
