package cn.element.adpater.login;

/**
 * 使用接口适配器优化代码
 */
public interface ILoginAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);
}
