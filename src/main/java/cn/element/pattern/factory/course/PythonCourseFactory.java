package cn.element.pattern.factory.course;

import cn.element.pattern.factory.simple.detail.ICourse;
import cn.element.pattern.factory.simple.detail.PythonCourse;

public class PythonCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
