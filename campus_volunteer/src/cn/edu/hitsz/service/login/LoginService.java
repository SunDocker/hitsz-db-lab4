package cn.edu.hitsz.service.login;

import cn.edu.hitsz.utils.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author SunDocker
 */
public abstract class LoginService extends HttpServlet {

    public static final String LOGIN_ERROR_PAGE = "/err/login_err.html";
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

        String contextPath = getServletContext().getContextPath();
        if (JDBCUtil.isResSetNull(rs)) {
            resp.sendRedirect(contextPath + LOGIN_ERROR_PAGE);
        } else {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/txt");
            out.println("登录成功");
        }

        JDBCUtil.close(null, ps, rs);
    }
}
