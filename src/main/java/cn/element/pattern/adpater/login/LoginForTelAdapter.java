package cn.element.pattern.adpater.login;

/**
 * 手机登录
 */
public class LoginForTelAdapter extends AbstractAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return loginForRegister(id, null);
    }
}
