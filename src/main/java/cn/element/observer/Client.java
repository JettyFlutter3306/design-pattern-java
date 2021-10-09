package cn.element.observer;

public class Client {

    public static void main(String[] args) {

        Debt zhangSan = new Borrower();  //创建被观察者

        //添加观察者
        zhangSan.borrow(() -> System.out.println("洛必达: 收款10000元"));
        zhangSan.borrow(() -> System.out.println("莱布尼茨: 收款80000元"));
        zhangSan.borrow(() -> System.out.println("王五: 收款8000元"));
        zhangSan.borrow(() -> System.out.println("赵柳: 收款10000元"));

        zhangSan.notifyCreditors();  //张三有钱了 通知观察者处理事件
    }
}
