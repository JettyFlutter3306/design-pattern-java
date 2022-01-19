package cn.element.composit.course;

public class Course extends CourseComponent {

    private final String name;
    private final double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CourseComponent catalogComponent) {
        return name;
    }

    @Override
    public double getPrice(CourseComponent catalogComponent) {
        return price;
    }

    @Override
    public void print() {
        System.out.println(name + " (¥" + price + "元)");
    }
}
