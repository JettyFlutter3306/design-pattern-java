package cn.element.mediator.chat;

public class Client {

    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        User tom = new User("Tom", room);
        User jerry = new User("Jerry", room);

        tom.sendMessage("Hi! I am Tom.");
        jerry.sendMessage("Hello!My name is Jerry.");
    }

}
