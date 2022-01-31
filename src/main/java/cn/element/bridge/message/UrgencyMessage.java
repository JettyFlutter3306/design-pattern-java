package cn.element.bridge.message;

/**
 * 具体加急消息
 */
public class UrgencyMessage extends AbstractMessage {

    public UrgencyMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String msg, String toUser) {
        msg = "加急: " + msg;
        super.sendMessage(msg, toUser);
    }

    /**
     * 扩展它的功能,监控某个消息的处理状态
     */
    public Object watch(String msg) {
        // 根据给出的消息编码(messageId),查询消息的处理状态
        // 组织成监控的处理状态
        return null;
    }
}
