package cn.element.pattern.flyweight.ticket;

public class Client {

    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTicket("深圳北", "潮汕");
        ticket.showInfo("硬座");
    }
}
