package cn.edu.hitsz.service.activity;

import cn.edu.hitsz.utils.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

/**
 * @author SunDocker
 */
@WebServlet("/activity/check")
public class ActivityCheckService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String no = req.getParameter("no");
        String check = req.getParameter("check");

        HttpSession session = req.getSession();
        String loginAuth = (String) session.getAttribute("loginAuth");
        String account = loginAuth.split(":")[1];

        String sql = "update participate " +
                "set check_status = '通过' " +
                "where activity_no = 1 and volunteer_account = 'lisi'";

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;

        JDBCUtil.setPreStateInt(ps, 1, Integer.parseInt(no));
        JDBCUtil.setPreStateString(ps, 2, account);

        int rowCount = JDBCUtil.executePreStateUpdate(ps);

        JDBCUtil.close(null, ps, null);

        String contextPath = getServletContext().getContextPath();
        if (rowCount == 1) {
            resp.sendRedirect(contextPath + "/err/activity_release_success.html");
        } else {
            resp.sendRedirect(contextPath + "/err/activity_release_err.html");
        }

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/txt");
        out.print("checkOK");
    }
}
