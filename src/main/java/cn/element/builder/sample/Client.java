package cn.element.builder.sample;

public class Client {

    public static void main(String[] args) {
        Course.CourseBuilder builder = new Course.CourseBuilder().addName("设计模式")
                                                    .addPPT("[PPT课件]")
                                                    .addVideo("[回放视频]")
                                                    .addNote("[课堂笔记]")
                                                    .addHomework("[课后作业]");

        System.out.println(builder.build());
    }
}
