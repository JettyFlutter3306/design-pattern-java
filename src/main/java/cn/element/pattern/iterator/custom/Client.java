package cn.element.pattern.iterator.custom;

public class Client {

    public static void main(String[] args) {
        Course java = new Course("Java架构");
        Course javaBase = new Course("Java入门");
        Course design = new Course("Java设计模式精讲");
        Course ai = new Course("人工智能");

        CourseAggregate aggregate = new CourseAggregateImpl();

        aggregate.add(java);
        aggregate.add(javaBase);
        aggregate.add(design);
        aggregate.add(ai);

        System.out.println("================课程列表=================");
        printCourses(aggregate);
    }

    public static void printCourses(CourseAggregate aggregate) {
        Iterator<Course> iterator = aggregate.iterator();

        while (iterator.hasNext()) {
            Course course = iterator.next();
            System.out.println("《" + course.getName() + "》");
        }
    }

}
