package cn.element.pattern.decorator.overlay;

public class Client {

    public static void main(String[] args) {
        BatterCake batterCake;

        // 买一个煎饼
        batterCake = new BaseBatterCake();

        // 加一个鸡蛋
        batterCake = new EggDecorator(batterCake);

        // 再加一个鸡蛋
        batterCake = new EggDecorator(batterCake);

        // 再加一根香肠
        batterCake = new SausageDecorator(batterCake);

        // 与静态代理的最大区别就是职责不同
        // 静态代理不一定要满足is-a的关系
        // 静态代理会做功能增强,同一个职责变得不一样

        // 装饰器更多的是扩展
        System.out.println(batterCake.getMsg() + ",总价: " + batterCake.getPrice());
    }

}
