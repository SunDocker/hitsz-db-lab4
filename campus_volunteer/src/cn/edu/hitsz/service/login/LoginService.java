package cn.edu.hitsz.service.login;

import cn.edu.hitsz.utils.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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

    abstract String getUserTable();

    abstract String getLoginErrPage();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");

        String sql = "select * from " + getUserTable()
                + " where account = ? and password = ?";

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;

        JDBCUtil.setPreStateString(ps, 1, account);
        JDBCUtil.setPreStateString(ps, 2, password);

        ResultSet rs = JDBCUtil.executePreStateQuery(ps);
        assert rs != null;

        String contextPath = getServletContext().getContextPath();
        if (JDBCUtil.isResSetNull(rs)) {
            resp.sendRedirect(contextPath + getLoginErrPage());
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("login", getUserTable());
            resp.sendRedirect(contextPath + "/activity/volunteer_activity_list.html");
        }
        JDBCUtil.close(null, ps, rs);
    }
}
