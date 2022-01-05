package cn.element.observer.demo;

public class Display1 implements StudentObserver {

    @Override
    public void updateInfo(Student student) {
        System.out.println(student.getId() + " " + student.getName());
    }
}
