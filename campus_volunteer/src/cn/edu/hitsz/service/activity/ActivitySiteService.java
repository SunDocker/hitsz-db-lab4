package cn.edu.hitsz.service.activity;

import cn.edu.hitsz.entity.ActivityCategory;
import cn.edu.hitsz.entity.ActivitySite;
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
@WebServlet("/activity/site")
public class ActivitySiteService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql = "select no, name from site";

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;

        ResultSet rs = JDBCUtil.executePreStateQuery(ps);
        assert rs != null;

        List<ActivitySite> sites = JDBCUtil.getResSetIntoList(rs, ActivitySite.class);

        JDBCUtil.close(null, ps, rs);

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(sites);

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/txt");
        out.println(jsonStr);
    }
}
