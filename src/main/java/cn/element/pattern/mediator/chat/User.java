package cn.element.pattern.mediator.chat;

public class User {

    private final String name;
    private final ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public void sendMessage(String msg) {
        chatRoom.showMsg(this, msg);
    }

    public String getName() {
        return name;
    }


}
