package cn.element.adpater.login;

public class Client {

    public static void main(String[] args) {
        PassportForThirdAdapter adapter = new PassportForThirdAdapter();

        adapter.login("tom", "123456");
        adapter.loginForQQ("sdsdsdsdsdfef");
        adapter.loginForWechat("sdscsvsdvsdvbb");
    }

}
