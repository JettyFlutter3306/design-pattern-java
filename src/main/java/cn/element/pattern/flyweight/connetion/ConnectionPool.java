package cn.element.pattern.flyweight.connetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {

    private Vector<Connection> pool;

    private final String url = "jdbc:mysql://lcoalhost:3306/test";
    private final String username = "root";
    private final String password = "root";
    private final String driverClassName = "com.mysql.jdbc.Driver";
    private final int poolSize = 100;

    public ConnectionPool() {
        pool = new Vector<>(poolSize);

        try {
            Class.forName(driverClassName);

            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                pool.add(connection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        if (pool.size() > 0) {
            Connection connection = pool.get(0);
            pool.remove(connection);

            return connection;
        }

        return null;
    }

    public synchronized void release(Connection connection) {
        pool.add(connection);
    }
}
