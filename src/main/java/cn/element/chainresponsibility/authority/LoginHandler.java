package cn.element.chainresponsibility.authority;

public class LoginHandler<T> extends Handler<T> {

    @Override
    public void doHandle(Member member) {
        System.out.println("登录成功!");
        member.setRoleName("管理员");
        chain.doHandle(member);
    }
}
