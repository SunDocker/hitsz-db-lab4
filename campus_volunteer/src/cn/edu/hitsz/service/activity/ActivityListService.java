package cn.edu.hitsz.service.activity;

import cn.edu.hitsz.entity.VolunteerActivity;
import cn.edu.hitsz.utils.JDBCUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author SunDocker
 */
@WebServlet("/activity/list")
public class ActivityListService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String order = req.getParameter("order");
        String sql = "";
        if (Objects.isNull(order)) {
            sql = "select * from volunteer_activity_detail order by no";
        } else if ("beginTime".equals(order)) {
            sql = "select * from volunteer_activity_detail order by beginTime";
        } else if ("endTime".equals(order)) {
            sql = "select * from volunteer_activity_detail order by endTime";
        }

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;

        ResultSet rs = JDBCUtil.executePreStateQuery(ps);
        assert rs != null;

        List<VolunteerActivity> activities = JDBCUtil.getResSetIntoList(rs, VolunteerActivity.class);

        JDBCUtil.close(null, ps, rs);

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(activities);

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/txt");
        out.println(jsonStr);
    }
}
