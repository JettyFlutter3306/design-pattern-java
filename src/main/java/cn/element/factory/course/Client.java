package cn.element.factory.course;

import cn.element.factory.simple.detail.ICourse;

public class Client {

    public static void main(String[] args) {
        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new JavaCourseFactory();
        course = factory.create();
        course.record();
    }

}
