package cn.element.state.login;

public class AppContext {

    public static final UserState STATE_LOGIN = new LoginState();
    public static final UserState STATE_UN_LOGIN = new UnLoginState();

    private UserState currentState = STATE_UN_LOGIN;

    {
        STATE_LOGIN.setContext(this);
        STATE_UN_LOGIN.setContext(this);
    }

    public void setState(UserState state) {
        this.currentState = state;
        this.currentState.setContext(this);
    }

    public UserState getCurrentState() {
        return currentState;
    }

    public void favorite() {
        currentState.favorite();
    }

    public void comment(String comment) {
        currentState.comment(comment);
    }
}
