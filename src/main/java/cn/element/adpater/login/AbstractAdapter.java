package cn.element.adpater.login;

public abstract class AbstractAdapter extends PassportService implements ILoginAdapter {

    public ResultMsg loginForRegister(String username, String password) {
        if (password == null) {
            password = "THIRD_EMPTY";
        }

        register(username, password);

        return login(username, password);
    }
}