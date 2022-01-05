package cn.element.observer.demo;

public class Display2 implements StudentObserver {

    @Override
    public void updateInfo(Student student) {
        System.out.println(student.getId() + " " + student.getBirthday());
    }
}
