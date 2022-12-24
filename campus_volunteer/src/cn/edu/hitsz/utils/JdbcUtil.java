package cn.edu.hitsz.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author SunDocker
 */
public class JdbcUtil {
    /**
     * 禁止实例化工具类
     */
    private JdbcUtil() {
    }

    /**
     * 读取配置文件
     */
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/campus_volunteer";
    static String user = "root";
    static String password = "123456";

    /**
     * 注册驱动
     */
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
