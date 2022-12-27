package cn.edu.hitsz.service.activity;

import cn.edu.hitsz.entity.ReleaseShow;
import cn.edu.hitsz.entity.SignupCheck;
import cn.edu.hitsz.utils.JDBCUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author SunDocker
 */
@WebServlet("/activity/showRelease")
public class ActivityShowReleaseService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String loginAuth = (String) session.getAttribute("loginAuth");
        String account = loginAuth.split(":")[1];

        String sql = "select name, category, site, beginTime, endTime " +
                "from volunteer_activity_detail " +
                "where adminAccount = ?";

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;

        JDBCUtil.setPreStateString(ps, 1, account);

        ResultSet rs = JDBCUtil.executePreStateQuery(ps);
        assert rs != null;

        List<ReleaseShow> shows = JDBCUtil.getResSetIntoList(rs, ReleaseShow.class);

        JDBCUtil.close(null, ps, rs);

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(shows);

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/txt");
        out.println(jsonStr);
    }
}
