package cn.element.pattern.state.login;

public class LoginState extends UserState {

    @Override
    public void favorite() {
        System.out.println("ζΆθζε!");
    }

    @Override
    public void comment(String comment) {
        System.out.println(comment);
    }
}
