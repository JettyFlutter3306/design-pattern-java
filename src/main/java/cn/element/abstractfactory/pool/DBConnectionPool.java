package cn.element.abstractfactory.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * 数据库连接池管理类
 */
public final class DBConnectionPool extends Pool {

    private int checkedOut;  // 正在使用的连接数

    private final Vector<Connection> freeConnections = new Vector<>();  // 存放产生的连接对象容器

    private String password = null;  // 密码

    private String url = null;  // 连接字符串

    private String username = null;  // 用户名

    private static int num = 0;  // 空闲连接数

    private static int numActive = 0;  // 当前可用的连接数

    private static DBConnectionPool pool = null;  // 连接池实例变量

    /**
     * 产生数据连接池
     */
    public static synchronized DBConnectionPool getInstance() {
        if (pool == null) {
            pool = new DBConnectionPool();
        }

        return pool;
    }

    /**
     * 获得一个数据库连接池的实例
     */
    private DBConnectionPool() {
        try {
            init();

            // 初始化normalConn个连接
            for (int i = 0; i < normalConnect; i++) {
                Connection connection = newConnection();

                if (connection != null) {
                    freeConnections.addElement(connection);  // 往容器中添加一个连接对象
                    num++;  // 记录总连接数
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化
     */
    private void init() throws IOException {
        InputStream is = DBConnectionPool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);

        this.username = p.getProperty("username");
        this.password = p.getProperty("password");
        this.driverName = p.getProperty("driverName");
        this.url = p.getProperty("url");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
    }

    /**
     * 创建一个新连接
     */
    private Connection newConnection() {
        Connection connection;

        try {
            if (username == null) {
                connection = DriverManager.getConnection(url);
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
            System.out.println("连接池创建一个新的连接");
        } catch (SQLException e) {
            System.out.println("无法创建这个URL连接: " + url);
            return null;
        }

       return connection;
    }

    /**
     * 关闭所有连接
     */
    @Override
    public synchronized void release() {
        try {
            // 将当前连接赋值到枚举中
            Enumeration<Connection> elements = freeConnections.elements();

            // 使用循环关闭连接池中所有连接
            while (elements.hasMoreElements()) {
                // 如果此枚举对象至少还有一个可提供的元素,则返回此枚举的下一个对象
                Connection connection = (Connection) elements.nextElement();

                try {
                    connection.close();
                    num--;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            freeConnections.removeAllElements();
            numActive = 0;
        } finally {
            super.release();
        }
    }

    @Override
    public void createPool() {
        pool = new DBConnectionPool();

        if (pool != null) {
            System.out.println("创建连接池成功!");
        } else {
            System.out.println("创建连接池失败!");
        }
    }

    /**
     * (单例模式)获取一个可用连接
     */
    @Override
    public synchronized Connection getConnection() {
        Connection connection = null;

        // 还有空闲的连接
        if (freeConnections.size() > 0) {
            num--;
            connection = (Connection) freeConnections.firstElement();
            freeConnections.removeElementAt(0);

            try {
                if (connection.isClosed()) {
                    System.out.println("从连接池删除一个无效连接");
                    connection = getConnection();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            // 没有空闲连接且当连接小于最允许值,若最大值为0,则不限制
        } else if (maxConnect == 0 || checkedOut < maxConnect) {
            connection = newConnection();
        }

        if (connection != null) {
            checkedOut++;
        }

        numActive++;
        return connection;
    }

    /**
     * 获取一个连接,并加上等待时间限制,时间为毫秒
     */
    @Override
    public synchronized Connection getConnection(long timeout) {
        long startTime = new Date().getTime();
        Connection connection;

        while ((connection = getConnection()) == null) {
            try {
                wait(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if ((new Date().getTime() - startTime) >= timeout) {
                return null;
            }
        }

        return connection;
    }

    @Override
    public synchronized void freeConnection(Connection connection) {
        freeConnections.add(connection);
        num++;
        checkedOut--;
        numActive++;
        notifyAll();  // 解锁
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public int getNumActive() {
        return numActive;
    }
}
