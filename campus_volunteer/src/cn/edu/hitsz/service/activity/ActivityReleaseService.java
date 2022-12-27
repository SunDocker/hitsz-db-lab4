package cn.edu.hitsz.service.activity;

import cn.edu.hitsz.entity.VolunteerActivity;
import cn.edu.hitsz.utils.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

/**
 * @author SunDocker
 */
@WebServlet("/activity/release")
public class ActivityReleaseService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String siteNo = req.getParameter("site_no");
        String content = req.getParameter("content");
        String num = req.getParameter("num");
        String beginTime = req.getParameter("begin_time");
        String endTime = req.getParameter("end_time");

        HttpSession session = req.getSession();
        String loginAuth = (String) session.getAttribute("loginAuth");
        String account = loginAuth.split(":")[1];

        String no = getActivityNo();

        String sql = "insert into " +
                "volunteer_activity(no, admin_account, category, site_no, name, begin_time, end_time, content, num) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;

        JDBCUtil.setPreStateInt(ps, 1, Integer.parseInt(no));
        JDBCUtil.setPreStateString(ps, 2, account);
        JDBCUtil.setPreStateString(ps, 3, category);
        JDBCUtil.setPreStateInt(ps, 4, Integer.parseInt(siteNo));
        JDBCUtil.setPreStateString(ps, 5, name);
        JDBCUtil.setPreStateString(ps, 6, beginTime);
        JDBCUtil.setPreStateString(ps, 7, endTime);
        JDBCUtil.setPreStateString(ps, 8, content);
        JDBCUtil.setPreStateInt(ps, 9, Integer.parseInt(num));

        int rowCount = JDBCUtil.executePreStateUpdate(ps);

        JDBCUtil.close(null, ps, null);

        String contextPath = getServletContext().getContextPath();
        if (rowCount == 1) {
            resp.sendRedirect(contextPath + "/err/activity_release_success.html");
        } else {
            resp.sendRedirect(contextPath + "/err/activity_release_err.html");
        }
    }

    private String getActivityNo() {
        String sql = "select no from volunteer_activity order by no desc LIMIT 1";

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;

        ResultSet rs = JDBCUtil.executePreStateQuery(ps);
        assert rs != null;

        List<String> no = JDBCUtil.getResSetStrings(rs, "no");

        JDBCUtil.close(null, ps, rs);

        return String.valueOf(Integer.parseInt(no.get(0)) + 1);
    }
}
