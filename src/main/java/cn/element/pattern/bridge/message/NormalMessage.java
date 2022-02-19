package cn.element.pattern.bridge.message;

/**
 * 普通消息类
 */
public class NormalMessage extends AbstractMessage {

    public NormalMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String msg, String toUser) {
        // 对于普通的消息,直接调用父类方法发送消息即可
        super.sendMessage(msg, toUser);
    }
}
