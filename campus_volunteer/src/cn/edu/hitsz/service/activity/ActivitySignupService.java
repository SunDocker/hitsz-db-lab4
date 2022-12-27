package cn.edu.hitsz.service.activity;

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
@WebServlet("/activity/signup")
public class ActivitySignupService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String loginAuth = (String) session.getAttribute("loginAuth");
        String account = loginAuth.split(":")[1];
        String activityNo = req.getParameter("activity_no");

        String sql = "insert into " +
                "participate(activity_no, volunteer_account, check_status) " +
                "values(?, ?, '待审核')";

        PreparedStatement ps = JDBCUtil.prepareStatement(sql);
        assert ps != null;

        JDBCUtil.setPreStateInt(ps, 1, Integer.parseInt(activityNo));
        JDBCUtil.setPreStateString(ps, 2, account);

        int rowCount = JDBCUtil.executePreStateUpdate(ps);

        JDBCUtil.close(null, ps, null);

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/txt");
        if (rowCount == 1) {
            out.print("signupOK");
        } else {
            out.print("signupFail");
        }

    }
}
