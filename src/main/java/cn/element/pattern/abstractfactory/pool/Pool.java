package cn.element.pattern.abstractfactory.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 使用抽象工厂模式重构数据库连接池
 *
 * 自定义连接池getInstance()返回POOL唯一实例,第一次调用时将执行构造函数
 * 构造函数Pool()调用驱动装载loadDrivers()函数
 * 连接池创建createPool()函数,loadDrivers()装载驱动
 * createPool()创建连接池,getConnection()返回一个连接实例
 * getConnection(long time)添加时间限制
 * freeConnection(Connection con)将con连接实例返回连接池,getNum()返回空闲连接数
 * getNumActive()返回当前使用的连接数
 */
public abstract class Pool {

    public String propertiesName = "connection-INF-properties";

    /**
     * 定义唯一实例
     */
    private static Pool instance = null;

    /**
     * 最大连接数
     */
    protected int maxConnect = 100;

    /**
     * 保持连接数
     */
    protected int normalConnect = 10;

    /**
     * 驱动字符串
     */
    protected String driverName = null;

    /**
     * 驱动类
     */
    protected Driver driver = null;

    /**
     * 私有构造函数,不允许外界访问
     */
    protected Pool() {
        try {
            init();
            loadDrivers(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化所有从配置文件中读取的成员变量
     */
    private void init() throws IOException {
        InputStream is = Pool.class.getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(is);

        this.driverName = properties.getProperty("driverName");
        this.maxConnect = Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));
    }

    /**
     * 装载和注册所有的JDBC驱动程序
     */
    protected void loadDrivers(String driverName) {
        try {
            driver = (Driver) Class.forName(driverName).newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册JDBC驱动程序: " + driverName);
        } catch (Exception e) {
            System.out.println("无法注册JDBC驱动程序: " + driverName + ",错误: " + e);
        }
    }

    /**
     * 创建连接池
     */
    public abstract void createPool();

    public static synchronized Pool getInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (instance == null) {
            instance = (Pool) Class.forName("").newInstance();
        }

        return instance;
    }

    /**
     * 获得一个可用的连接,如果没有,则创建一个连接,并且小于最大连接
     */
    public abstract Connection getConnection();

    /**
     * 获得一个连接,有时间限制
     */
    public abstract Connection getConnection(long time);

    /**
     * 将连接对象返回连接池
     */
    public abstract void freeConnection(Connection connection);

    /**
     * 返回当前空闲的连接数
     */
    public abstract int getNum();

    /**
     * 返回当前工作的连接数
     */
    public abstract int getNumActive();

    /**
     * 关闭所有连接,撤销驱动注册(单例方法)
     */
    protected synchronized void release() {
        // 撤销驱动
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销JDBC驱动程序 " + driver.getClass().getName());
        } catch (SQLException e) {
            System.out.println("无法撤销JDBC驱动程序的注册: " + driver.getClass().getName());
        }
    }




}