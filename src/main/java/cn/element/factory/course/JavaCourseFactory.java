package cn.element.factory.course;

import cn.element.factory.simple.detail.ICourse;
import cn.element.factory.simple.detail.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
