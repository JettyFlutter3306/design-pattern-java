package cn.element.adpater.common;

/**
 * 接口适配器的通用写法
 * 接口适配器的关注点与类适配器,对象适配器的关注点不太一样,类适配器和对象适配器
 * 着重于将系统存在的一个角色(Adaptee)转化成目标接口(ITarget)所需内容,而接口
 * 适配器的使用场景是当接口的方法过多时,如果直接实现接口,则会类爆炸,显得很臃肿
 * 此时使用接口适配器就能只实现我们需要的接口方法,使得目标更清晰
 */
public interface DC {

    int output5V();

    int output12V();

    int output24V();

    int output36V();
}
