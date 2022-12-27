package cn.edu.hitsz.service.activity;

import cn.edu.hitsz.entity.ActivityCategory;
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
import java.util.List;

/**
 * @author SunDocker
 */
@WebServlet("/activity/category")
public class ActivityCategoryService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql = "select name from activity_category";

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;

        ResultSet rs = JDBCUtil.executePreStateQuery(ps);
        assert rs != null;

        List<ActivityCategory> categories = JDBCUtil.getResSetIntoList(rs, ActivityCategory.class);

        JDBCUtil.close(null, ps, rs);

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(categories);

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/txt");
        out.println(jsonStr);
    }
}
