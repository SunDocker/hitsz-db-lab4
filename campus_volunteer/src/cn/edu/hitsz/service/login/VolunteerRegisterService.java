package cn.edu.hitsz.service.login;

import cn.edu.hitsz.utils.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author SunDocker
 */
@WebServlet("/register/volunteer")
public class VolunteerRegisterService extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");

        String sql = "insert into volunteer(account,password,nickname,star,college_no,org_no,volunteer_time) " +
                "values(?,?,?,'普通志愿者',0,0,0)";

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;

        JDBCUtil.setPreStateString(ps, 1, account);
        JDBCUtil.setPreStateString(ps, 2, password);
        JDBCUtil.setPreStateString(ps, 3, nickname);

        int rowCount = JDBCUtil.executePreStateUpdate(ps);
        String contextPath = getServletContext().getContextPath();

        if (rowCount == 1) {
            resp.sendRedirect(contextPath + "/err/volunteer_register_success.html");
        } else {
            resp.sendRedirect(contextPath + "/err/volunteer_register_err.html");
        }
    }
}
