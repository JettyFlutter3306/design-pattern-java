package cn.element.observer.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Student {

    private final List<StudentObserver> observers = new ArrayList<>();

    private Integer id;

    private String name;

    private Date birthday;

    public void notifyObservers(Student student) {
        observers.forEach(o -> o.updateInfo(student));
    }

    public Student addObserver(StudentObserver observer) {

        this.observers.add(observer);

        return this;
    }

}
