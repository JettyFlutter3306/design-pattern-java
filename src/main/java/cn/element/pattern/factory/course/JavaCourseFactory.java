package cn.element.pattern.factory.course;

import cn.element.pattern.factory.simple.detail.ICourse;
import cn.element.pattern.factory.simple.detail.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
