package cn.element.pattern.delegate.task;

public class Client {

    public static void main(String[] args) {
        Boss boss = new Boss();
        Leader leader = new Leader();

        boss.command("海报图", leader);
        boss.command("爬虫", leader);
        boss.command("卖手机", leader);
    }

}
