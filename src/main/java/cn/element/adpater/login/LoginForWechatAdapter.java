package cn.element.adpater.login;

public class LoginForWechatAdapter extends AbstractAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWechatAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return loginForRegister(id, null);
    }
}
