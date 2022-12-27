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
        String volunteerAccount = req.getParameter("volunteerAccount");


        PrintWriter out = resp.getWriter();
        resp.setContentType("text/txt");

        String sql = "update participate " +
                "set check_status = ? " +
                "where activity_no = ? and volunteer_account = ?";

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;

        if ("0".equals(check)) {
            JDBCUtil.setPreStateString(ps, 1, "拒绝");
        } else if ("1".equals(check)) {
            JDBCUtil.setPreStateString(ps, 1, "通过");
        } else {
            out.print("checkErr");
            JDBCUtil.close(null, ps, null);
            return;
        }
        JDBCUtil.setPreStateInt(ps, 2, Integer.parseInt(no));
        JDBCUtil.setPreStateString(ps, 3, volunteerAccount);

        int rowCount = JDBCUtil.executePreStateUpdate(ps);

        JDBCUtil.close(null, ps, null);

        String contextPath = getServletContext().getContextPath();
        if (rowCount == 1) {
            out.print("checkOK");
        } else {
            out.print("checkErr");
        }
    }
}
