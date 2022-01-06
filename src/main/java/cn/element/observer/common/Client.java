package cn.element.observer.common;

public class Client {

    public static void main(String[] args) {
        ISubject<String> subject = new ConcreteSubject<>();
        IObserver<String> observer = new ConcreteObserver<>();

        subject.attach(observer);       //注册观察者
        subject.notify("hello");  //通知观察者
    }
}
