package cn.edu.hitsz;

import cn.edu.hitsz.utils.JdbcUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author SunDocker
 */
@WebServlet("/main")
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Servlet !");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            String sql = "select * from volunteer";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("account")
                        + "'s nickname: "
                        + rs.getString("nickname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, ps, rs);
        }

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/txt");
        out.println("HttpServlet doGet !");
    }
}
