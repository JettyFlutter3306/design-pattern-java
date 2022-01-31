package cn.element.bridge.message;

public class Client {

    public static void main(String[] args) {
        IMessage message = new SmsMessage();
        AbstractMessage abstractMessage = new NormalMessage(message);
        abstractMessage.sendMessage("加班申请请速批", "王总");

        message = new EmailMessage();
        abstractMessage = new UrgencyMessage(message);
        abstractMessage.sendMessage("加班申请速批", "王总");
    }

}
