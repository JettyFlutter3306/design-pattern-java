package cn.element.bridge.message;

/**
 * 短信消息的实现类
 */
public class SmsMessage implements IMessage {

    @Override
    public void send(String message, String toUser) {
        System.out.println("使用短信消息发送: " + message + "给" + toUser);
    }
}
