package cn.element.pattern.composit.course;

public class Client {

    public static void main(String[] args) {
        System.out.println("=================透明组合模式====================");

        CourseComponent javaBase = new Course("Java入门课程", 8200);
        CourseComponent ai = new Course("人工智能", 5000);

        CourseComponent coursePackage = new CoursePackage("Java架构师课程", 2);

        CourseComponent design = new CoursePackage("Java设计模式", 1500);
        CourseComponent source = new CoursePackage("源码分析", 2000);
        CourseComponent softSkill = new CoursePackage("Java设计模式", 3000);

        coursePackage.addChild(design)
                     .addChild(source)
                     .addChild(softSkill);

        CourseComponent catalog = new CoursePackage("课程主目录", 1);

        catalog.addChild(javaBase)
               .addChild(ai)
               .addChild(coursePackage);

        catalog.print();
    }

}
