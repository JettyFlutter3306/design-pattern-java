package cn.element.observer.api;

public class Client {

    public static void main(String[] args) {
        GPer per = GPer.getInstance();
        Teacher tom = new Teacher("tom");
        Teacher jerry = new Teacher("Jerry");

        per.addObserver(tom);
        per.addObserver(jerry);

        //用户行为
        Question question = new Question();
        question.setUsername("张三");
        question.setContent("观察者模式适用于哪些场景?");

        per.publishQuestion(question);
    }
}
