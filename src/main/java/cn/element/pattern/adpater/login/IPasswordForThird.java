package cn.element.pattern.adpater.login;

/**
 * 第三方登录接口
 */
public interface IPasswordForThird {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForPhone(String phone, String code);
}
