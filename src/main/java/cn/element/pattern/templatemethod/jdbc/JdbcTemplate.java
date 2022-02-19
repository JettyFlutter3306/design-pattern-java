package cn.element.pattern.templatemethod.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {

    private final DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public final <T> List<T> executeQuery(String sql, RowMapper<T> rowMapper, Object[] values) {
        try {
            // 1.获取连接
            Connection connection = getConnection();

            // 2.创建语句集
            PreparedStatement statement = createPreparedStatement(connection, sql);

            // 3.执行语句集
            ResultSet rs = executeQuery(statement, values);

            // 4.处理结果集
            List<T> list = parseResultSet(rs, rowMapper);

            // 5.关闭结果集
            rs.close();

            // 6.关闭语句集
            statement.close();

            // 7.关闭连接
            connection.close();

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private <T> List<T> parseResultSet(ResultSet rs, RowMapper<T> rowMapper) throws Exception {
        List<T> list = new ArrayList<>();
        int rowNum = 0;

        while (rs.next()) {
            list.add(rowMapper.mapRow(rs, rowNum++));
        }

        return list;
    }

    private ResultSet executeQuery(PreparedStatement statement, Object[] values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            statement.setObject(i, values[i]);
        }

        return statement.executeQuery();
    }

    protected PreparedStatement createPreparedStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
