package cn.element.iterator.custom;

/**
 * 课程集合CourseAggregate接口
 */
public interface CourseAggregate {

    void add(Course course);

    void remove(Course course);

    Iterator<Course> iterator();
}
