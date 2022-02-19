package cn.element.pattern.factory.simple.detail;

/**
 * 父类ICourse指向子类JavaCourse的引用,应用层代码需要依赖JavaCourse
 * 如果业务扩展,则继续增加PythonCourse,甚至更多,那么客户端的依赖会变得o
 * 越来越臃肿,因此我们要想办法把这种依赖减弱,把创建的细节隐藏,虽然在目前的代码中
 * 创建对象的过程并不复杂,但从代码设计角度来讲不易于扩展,因此用简单工厂模式对代码进行优化
 */
public class CourseFactory {

    public static ICourse create(Class<? extends ICourse> clazz) {
        try {
            if (clazz != null) {
                return clazz.newInstance();
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}