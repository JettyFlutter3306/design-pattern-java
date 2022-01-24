package cn.element.factory.simple.detail;

import java.util.Objects;

public class Client {

    public static void main(String[] args) {
        Objects.requireNonNull(CourseFactory.create(JavaCourse.class))
               .record();
    }

}
