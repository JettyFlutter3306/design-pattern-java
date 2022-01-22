package cn.element.adpater.login;

public class PassportForThirdAdapter extends PassportService implements IPasswordForThird {

    @Override
    public ResultMsg loginForQQ(String openId) {
        return loginForRegister(openId, null);
    }

    @Override
    public ResultMsg loginForWechat(String openId) {
        return loginForRegister(openId, null);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return loginForRegister(token, null);
    }

    @Override
    public ResultMsg loginForPhone(String phone, String code) {
        return loginForRegister(phone, null);
    }

    private ResultMsg loginForRegister(String username, String password) {
        if (password == null) {
            password = "THIRD_EMPTY";
        }

        register(username, password);

        return login(username, password);
    }

    private ResultMsg processLogin(String id, Class<? extends ILoginAdapter> clazz) {
        try {
            ILoginAdapter adapter = clazz.newInstance();

            if (adapter.support(adapter)) {
                return adapter.login(id, adapter);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
