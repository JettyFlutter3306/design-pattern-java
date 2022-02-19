package cn.element.pattern.state.login;

public class UnLoginState extends UserState {

    @Override
    public void favorite() {
        switch2Login();
        context.getCurrentState().favorite();
    }

    @Override
    public void comment(String comment) {
        switch2Login();
        context.getCurrentState().comment(comment);
    }

    private void switch2Login() {
        System.out.println("跳转到登录界面!");
        context.setState(AppContext.STATE_LOGIN);
    }
}
