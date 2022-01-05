package cn.element.observer.demo;

@FunctionalInterface
public interface StudentObserver {

    void updateInfo(Student student);
}
