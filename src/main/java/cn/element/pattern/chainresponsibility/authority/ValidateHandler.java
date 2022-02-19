package cn.element.pattern.chainresponsibility.authority;

import cn.hutool.core.util.StrUtil;

public class ValidateHandler<T> extends Handler<T> {

    @Override
    public void doHandle(Member member) {
        if (StrUtil.isEmpty(member.getLoginName()) || StrUtil.isEmpty(member.getLoginPass())) {
            System.out.println("用户名或密码为空!");
            return;
        }

        System.out.println("用户名和密码校验成功,可以往下执行");
        chain.doHandle(member);
    }

}
