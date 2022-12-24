package cn.edu.hitsz.service.login;

import cn.edu.hitsz.utils.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author SunDocker
 */
public abstract class LoginService extends HttpServlet {
    protected String userTable;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");

        String sql = "select * from " + userTable
                + " where account = ? and password = ?";

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;
        JDBCUtil.setPreStateString(ps, 1, account);
        JDBCUtil.setPreStateString(ps, 2, password);

        ResultSet rs = JDBCUtil.executePreStateQuery(ps);
        assert rs != null;
        List<String> nickname = JDBCUtil.getResSetStrings(rs, "nickname");
        List<String> regTime = JDBCUtil.getResSetStrings(rs, "register_time");

        System.out.println("table: " + userTable);
        System.out.println("nickname: " + nickname.get(0));
        System.out.println("register time: " + regTime.get(0));

        JDBCUtil.close(null, ps, rs);
    }
}
