package cn.element.composit.course;

import java.util.ArrayList;
import java.util.List;

public class CoursePackage extends CourseComponent {

    private final List<CourseComponent> items = new ArrayList<>();

    private final String name;

    private final Integer level;

    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public CourseComponent addChild(CourseComponent catalogComponent) {
        items.add(catalogComponent);
        return this;
    }

    @Override
    public CourseComponent removeChild(CourseComponent catalogComponent) {
        items.remove(catalogComponent);
        return this;
    }

    @Override
    public String getName(CourseComponent catalogComponent) {
        return name;
    }

    @Override
    public void print() {
        System.out.println(name);

        for (CourseComponent item : items) {
            // 控制显示格式
            if (level != null) {
                for (int i = 0; i < level; i++) {
                    // 打印空格控制格式
                    System.out.print(" ");
                }

                for (int i = 0; i < level; i++) {
                    // 每一行开始打印一个 + 号
                    if (i == 0) {
                        System.out.print("+");
                    }

                    System.out.print("-");
                }
            }

            // 打印标题
            item.print();
        }
    }
}
