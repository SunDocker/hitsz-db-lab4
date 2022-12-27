package cn.edu.hitsz.service.user;

import cn.edu.hitsz.entity.VolunteerActivity;
import cn.edu.hitsz.entity.VolunteerDetail;
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
import java.util.Objects;

/**
 * @author SunDocker
 */
@WebServlet("/user/detail")
public class UserDetailService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String loginAuth = (String) session.getAttribute("loginAuth");
        String[] authSplit = loginAuth.split(":");
        String table = authSplit[0];
        String account = authSplit[1];

        String sql = "select * from "
                + ("volunteer".equals(table) ? "volunteer_detail" : table)
                + " where account = ?";

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;
        JDBCUtil.setPreStateString(ps, 1, account);

        ResultSet rs = JDBCUtil.executePreStateQuery(ps);
        assert rs != null;

        List<?> userDetailList = null;
        try {
            char[] tableLetters = table.toCharArray();
            tableLetters[0] -= 32;
            userDetailList = JDBCUtil.getResSetIntoList(rs,
                    Class.forName("cn.edu.hitsz.entity." + String.valueOf(tableLetters) + "Detail"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert userDetailList != null;

        JDBCUtil.close(null, ps, rs);

        Object userDetail = userDetailList.get(0);
        if (userDetail instanceof VolunteerDetail) {
            VolunteerDetail volunteerDetail = (VolunteerDetail) userDetail;
            if (Objects.isNull(volunteerDetail.getNickname())) {
                volunteerDetail.setNickname(volunteerDetail.getAccount());
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(userDetail);

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/txt");
        out.println(jsonStr);
    }
}
