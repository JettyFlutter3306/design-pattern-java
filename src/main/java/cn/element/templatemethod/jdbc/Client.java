package cn.element.templatemethod.jdbc;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<Member> members = memberDao.selectAll();
        members.forEach(System.out::println);
    }

}
