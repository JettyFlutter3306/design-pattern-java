package cn.element.pattern.singleton.common;

public class Client {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
    }

}
