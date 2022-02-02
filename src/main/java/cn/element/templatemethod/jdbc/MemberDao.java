package cn.element.templatemethod.jdbc;

import javax.sql.DataSource;
import java.util.List;

public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<Member> selectAll() {
        String sql = "select * from t_member";

        return executeQuery(sql, (rs, rowNum) -> {
            Member member = new Member();
            // 字段过多就用原型模式
            member.setUsername(rs.getString("username"));
            member.setPassword(rs.getString("password"));
            member.setAge(rs.getInt("age"));
            member.setAddr(rs.getString("addr"));

            return member;
        }, null);
    }
}
