package cn.element.chainresponsibility.common;

/**
 * 责任链模式(Chain of Responsibility Pattern) 将链中每一个节点都看作一个对象
 * 每个节点处理的请求均不相同,且内部自动维护下一个节点对象,当一个请求从链式的首端
 * 发出时,会沿着责任链预设的路径依次传递到每一个节点对象,直到被链中的某个对象处理为止
 * 属于行为型设计模式
 */
public abstract class Handler {

    protected Handler next;

    public Handler setNextHandler(Handler successor) {
        this.next = successor;
        return this;
    }

    public abstract void handleRequest(String request);

}