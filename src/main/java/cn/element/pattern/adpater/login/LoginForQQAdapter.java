package cn.element.pattern.adpater.login;

public class LoginForQQAdapter extends AbstractAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        if (!support(adapter)) {
            return null;
        }

        // accessToken
        // time

        return loginForRegister(id, null);
    }
}
