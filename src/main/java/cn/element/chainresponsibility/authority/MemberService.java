package cn.element.chainresponsibility.authority;

public class MemberService {

    public void login(String loginName, String loginPass) {
        Handler.Builder<String> builder = new Handler.Builder<>();
        builder.addHandler(new ValidateHandler<>())
               .addHandler(new LoginHandler<>())
               .addHandler(new AuthHandler<>());

        builder.build().doHandle(new Member(loginName, loginPass));
    }

    public static void main(String[] args) {
        MemberService service = new MemberService();
        service.login("tom", "666");
    }

}
