package cn.element.adpater.login;

public class LoginForTokenAdapter extends AbstractAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTokenAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return loginForRegister(id, null);
    }
}
