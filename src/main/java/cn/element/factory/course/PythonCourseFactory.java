package cn.element.factory.course;

import cn.element.factory.simple.detail.ICourse;
import cn.element.factory.simple.detail.PythonCourse;

public class PythonCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
