package cn.element.pattern.composit.course;

/**
 * 创建一个顶层的抽象组件CourseComponent
 * 为什么不用抽象方法?
 *
 * 因为假如使用抽象方法的话,那么子类就必须要实现!
 * 子类继承此抽象类之后,只需要重写有差异的方法覆盖父类的方法即可
 */
public abstract class CourseComponent {

    public CourseComponent addChild(CourseComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public CourseComponent removeChild(CourseComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public String getName(CourseComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    public double getPrice(CourseComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持获取价格操作");
    }

    public void print() {
        throw new UnsupportedOperationException("不支持打印操作");
    }

}
