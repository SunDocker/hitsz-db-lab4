package cn.edu.hitsz.service.activity;

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
import java.util.List;

/**
 * @author SunDocker
 */
@WebServlet("/activity/check")
public class ActivityCheckService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String activityNo = req.getParameter("no");
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
            increaseVolunteerTime(volunteerAccount, activityNo);
        } else {
            out.print("checkErr");
            JDBCUtil.close(null, ps, null);
            return;
        }
        JDBCUtil.setPreStateInt(ps, 2, Integer.parseInt(activityNo));
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

    private void increaseVolunteerTime(String volunteerAccount, String activityNo) {
        String sqlHour = "select time_to_sec(timediff(end_time, begin_time))/3600 activity_hour " +
                "from volunteer_activity " +
                "where no = ?";
        String sqlTime = "select volunteer_time from volunteer where account = ?";
        String sqlUpdate = "update volunteer set volunteer_time = ?, star = ? where account = ?";

        PreparedStatement psHour = JDBCUtil.prepareStatement(sqlHour);
        PreparedStatement psTime = JDBCUtil.prepareStatement(sqlTime);
        PreparedStatement psUpdate = JDBCUtil.prepareStatement(sqlUpdate);
        assert psHour != null;
        assert psTime != null;
        assert psUpdate != null;

        JDBCUtil.setPreStateInt(psHour, 1, Integer.parseInt(activityNo));
        JDBCUtil.setPreStateString(psTime, 1, volunteerAccount);
        JDBCUtil.setPreStateString(psUpdate, 3, volunteerAccount);

        ResultSet rsHour = JDBCUtil.executePreStateQuery(psHour);
        ResultSet rsTime = JDBCUtil.executePreStateQuery(psTime);
        assert rsHour != null;
        assert rsTime != null;

        List<String> activityHourList = JDBCUtil.getResSetStrings(rsHour, "activity_hour");
        List<String> volunteerTimeList = JDBCUtil.getResSetStrings(rsTime, "volunteer_time");

        float activityHour = Float.parseFloat(activityHourList.get(0));
        float volunteerTime = Float.parseFloat(volunteerTimeList.get(0));
        float newTime = activityHour + volunteerTime;

        JDBCUtil.setPreStateFloat(psUpdate, 1, newTime);
        if (0 <= newTime && newTime < 100) {
            JDBCUtil.setPreStateString(psUpdate, 2, "普通志愿者");
        } else if (100 <= newTime && newTime < 300) {
            JDBCUtil.setPreStateString(psUpdate, 2, "一星级志愿者");
        } else if (300 <= newTime && newTime < 600) {
            JDBCUtil.setPreStateString(psUpdate, 2, "二星级志愿者");
        } else if (600 <= newTime) {
            JDBCUtil.setPreStateString(psUpdate, 2, "三星级志愿者");
        } else {
            throw new RuntimeException("志愿时间计算出错！");
        }

        int rowCount = JDBCUtil.executePreStateUpdate(psUpdate);
        if (rowCount != 1) {
            throw new RuntimeException("数据库更新异常！");
        }
    }
}
