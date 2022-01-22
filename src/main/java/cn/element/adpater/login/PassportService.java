package cn.element.adpater.login;

public class PassportService {

    /**
     * 注册方法
     */
    public ResultMsg register(String username, String password) {
        return new ResultMsg(200, "注册方法", new Member());
    }

    /**
     * 登录方法
     */
    public ResultMsg login(String username, String password) {
        return null;
    }

}
