package cn.element.factory.simple.detail;

/**
 * Java课程的实现类
 */
public class JavaCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("录制Java课程");
    }
}
