package cn.element.observer.demo;

import java.util.Date;

public class Display {

    private final StudentObserver display1 = new Display1();
    private final StudentObserver display2 = new Display2();
    private final Student student = new Student();

    {
        student.setId(10)
                .setName("洛必达")
                .setBirthday(new Date());

        student.addObserver(display1)
                .addObserver(display2);
    }

    public void display1() {
        display1.updateInfo(student);
    }

    public void display2() {
        display2.updateInfo(student);
    }

    public void display3(Integer id, String name, Date birthday) {

        student.setId(id)
                .setName(name)
                .setBirthday(birthday);

        student.notifyObservers(student);
    }

    public static void main(String[] args) {

        Display display = new Display();

        display.display1();
        display.display2();

        display.display3(15, "牛顿", new Date());

    }
}
