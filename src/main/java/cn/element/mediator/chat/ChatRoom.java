package cn.element.mediator.chat;

/**
 * 使用中介者模式设计群聊场景
 */
public class ChatRoom {

    public void showMsg(User user, String msg) {
        System.out.println("[" + user.getName() + "]:" + msg);
    }
}
