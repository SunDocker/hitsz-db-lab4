package cn.edu.hitsz.utils;

import cn.edu.hitsz.entity.VolunteerActivity;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author SunDocker
 */
public class JDBCUtil {
    /**
     * 禁止实例化工具类
     */
    private JDBCUtil() {
    }

    /**
     * 读取配置文件
     */
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/campus_volunteer";
    static String user = "root";
    static String password = "123456";

    static Connection conn;

    // 注册驱动
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
    public static Connection getConnection() {
        try {
            if (Objects.isNull(conn) || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static PreparedStatement prepareStatement(String sql) {
        try {
            return getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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

    public static void setPreStateString(PreparedStatement ps, int parameterIndex, String x) {
        try {
            ps.setString(parameterIndex, x);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executePreStateQuery(PreparedStatement ps) {
        try {
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int executePreStateUpdate(PreparedStatement ps) {
        try {
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static List<String> getResSetStrings(ResultSet rs, String columnLabel) {
        List<String> res = new ArrayList<>();
        try {
            while (rs.next()) {
                res.add(rs.getString(columnLabel));
            }
            rs.beforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static boolean isResSetNull(ResultSet rs) {
        boolean isNull = false;
        try {
            rs.beforeFirst();
            isNull = !rs.next();
            rs.previous();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isNull;
    }

    public static <T> List<T> getResSetIntoList(ResultSet rs, Class<T> elemClass) {
        List<T> list = new ArrayList<>();
        try {
            while (rs.next()) {
                T elem = elemClass.newInstance();
                for (Field field : elemClass.getFields()) {
                    field.set(elem, rs.getString(field.getName()));
                }
                list.add(elem);
            }
            rs.beforeFirst();
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }
}
